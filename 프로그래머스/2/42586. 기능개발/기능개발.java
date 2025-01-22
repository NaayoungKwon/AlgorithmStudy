import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        int n = progresses.length;
        int[] days = new int[n];
        for(int i = 0 ; i < n ; i++){
            days[i] = (int)Math.ceil((double)(100 - progresses[i])/speeds[i]);
        }
        int c = 1, prev = days[0];
        for(int i = 1 ; i < n ; i++){
            if(prev >= days[i]){
                c += 1;
            } else {
                answer.add(c);
                c = 1;
                prev = days[i];
            }
        }
        answer.add(c);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}