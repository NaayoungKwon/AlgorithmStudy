import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int[] sortedD = Arrays.stream(d)
                .boxed()
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
        for(int i = 0 ; i < sortedD.length ; i++){
            if(budget - sortedD[i] >= 0){
                budget -= sortedD[i];
                answer += 1;
            } else{
                break;
            }
        }
        return answer;
    }
}