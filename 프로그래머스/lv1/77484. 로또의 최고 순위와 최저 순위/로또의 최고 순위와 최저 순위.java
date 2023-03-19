import java.util.*;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int match = 0;
        int dontKnow = 0;
        for(int lot : lottos){
            if(lot == 0){
                dontKnow += 1;
            } else if (IntStream.of(win_nums).anyMatch(x -> x == lot)){
                match += 1;
            }
        }
        int[] answer = new int[2];
        // System.out.println(match + " " + dontKnow);
        answer[1] = Math.min(6, 7 - match);
        answer[0] = Math.min(6, 7- match-dontKnow);
        return answer;
    }
}