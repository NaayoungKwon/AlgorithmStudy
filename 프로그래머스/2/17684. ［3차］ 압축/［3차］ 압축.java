import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        }

        int a = 0;
        while(a < msg.length()){
            String now = msg.charAt(a) + "";
            if(a == msg.length() - 1){
                answer.add(dictionary.get(now));
                break;
            }
            for(int k = a + 1; k < msg.length(); k++){
                String after = now + msg.charAt(k);
                if(!dictionary.containsKey(after)){
                    answer.add(dictionary.get(now));
                    dictionary.put(after, dictionary.size() + 1);
                    a = k;
                    break;
                }else if(k == msg.length() - 1){
                    answer.add(dictionary.get(after));
                    a = k+1;
                    break;
                }
                now = after;
                a = k;
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}