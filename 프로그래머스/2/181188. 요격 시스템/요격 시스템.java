import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1,o2)->o1[1]-o2[1]);

        answer += 1;
        double last = targets[0][1] -0.5;
        for(int i = 1; i< targets.length; i++){
            if(targets[i][0] <= last){
                // System.out.println("skip " + targets[i][0] + " " + targets[i][1]);
                continue;
            } else {
                answer += 1;
                last = (targets[i][1] - 0.5);
                // System.out.println("add " + targets[i][0] + " " + targets[i][1]);
            }
        }

        return answer;
    }
}