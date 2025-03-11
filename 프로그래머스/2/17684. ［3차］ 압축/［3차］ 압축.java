import java.util.*;
class Solution {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();
        for(int i = 1 ; i <= 26 ; i++){
            char c = (char) ('A' - 1 + i);
            dictionary.put(String.valueOf(c), i);
        }
        int n = msg.length();
        int lastIdx = 27, i = 0, l = 2;
        while(i + l <= n){
            String subMsg = msg.substring(i, i + l);
            if(!dictionary.containsKey(subMsg)){
                String prevMsg = msg.substring(i, i+l-1);
                answer.add(dictionary.get(prevMsg));
                dictionary.put(subMsg, lastIdx);
                lastIdx++;
                i += (l-1);
                l = 2;
            } else {
                l += 1;
            }
        }
        if(i + l -1 <= n){
            String prevMsg = msg.substring(i, i+l-1);
            answer.add(dictionary.get(prevMsg));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}