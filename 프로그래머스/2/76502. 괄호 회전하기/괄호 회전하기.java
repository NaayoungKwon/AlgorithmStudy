import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;

        Set<String> open = new HashSet<>(List.of("[", "{", "("));
        Set<String> close = new HashSet<>(List.of("]", "}", ")"));
        String[] chars = s.split("");
        for(int start = 0 ; start < chars.length ; start++){
            Stack<String> st = new Stack<>();
            int end = (start + chars.length -1) % chars.length;
            for(int idx = 0; idx < chars.length  ; idx++){
                int i = (start + idx) % chars.length;
                if((st.isEmpty() || close.contains(st.peek()))&& close.contains(chars[i])){
                    st.add(chars[i]);
                    break;
                } else if (open.contains(chars[i])){
                    st.add(chars[i]);
                } else if ((st.peek().equals("[") && chars[i].equals("]")) || (st.peek().equals("{") && chars[i].equals("}")) || (st.peek().equals("(") && chars[i].equals(")"))){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                answer += 1;
            }
//            System.out.println(String.format("start : %d, end : %d, answer : %d, st : %d",start, end, answer, st.size()));

        }
        return answer;
    }
}