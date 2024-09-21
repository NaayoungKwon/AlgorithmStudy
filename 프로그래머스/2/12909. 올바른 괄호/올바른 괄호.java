import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            String c = s.substring(i,i+1);
            // System.out.println(c);
            if(c.equals("(")){
                st.push(c);
            } else if (st.empty()){
                return false;
            } else {
                String b = st.pop();
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        // System.out.println(st.size());

        return st.empty();
    }
}