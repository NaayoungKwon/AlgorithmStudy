import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int j = 0;
        for(int i= people.length -1 ; i >= 0; i--){
            if (i < j){
                break;
            }
            int sum = people[i];
            if( i > j) {
                if(sum + people[j] <= limit){
                    sum += people[j];
                    j += 1;
                }
            }
            answer += 1;
        }
        
        return answer;
    }
}