import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int[][] scores) {
        int n = scores.length;
        PriorityQueue<Score> pq = new PriorityQueue<>(Score::compareTo);
        Score target = null;
        for(int i = 0 ; i < n ; i++){
            int a = scores[i][0];
            int b = scores[i][1];
            Score score = new Score(i, a, b);
            pq.add(score);
            if (i == 0){
                target = score;
            }
        }

        int level = 1;
        int max_b = 0;
        while(!pq.isEmpty()){
            Score score = pq.poll();
            max_b = Math.max(max_b, score.b);

            if(max_b > score.b && score.i == 0){
                return -1;
            } else if (max_b > score.b){
                continue;
            }

            if(score.getSum() > target.getSum()){
                level++;
            }
        }

        return level;
    }

    public static class Score{
        int i;
        int a;
        int b;

        public Score(int i, int a, int b) {
            this.i = i;
            this.a = a;
            this.b = b;
        }

        public int getSum(){
            return this.a + this.b;
        }

        public int compareTo(Score score){
            if(this.a != score.a){
                return -(this.a - score.a);
            } else if (this.b != score.b){
                return (this.b - score.b);
            }
            return 0;
        }
        
    }


}