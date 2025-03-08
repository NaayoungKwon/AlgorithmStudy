import java.util.stream.IntStream;
class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        SC[] dp = new SC[target+1];

//        dp[0] = new SC(0, 0);
        for(int i : IntStream.range(1, 21).toArray()){
            for(int j = 1 ; j <= 3 ; j++){
                int d = i * j;
//                SC[] new_dp = new SC[target+1];
                for(int k = 1 ; k <= target ; k++){
                    if(d == 1){
                        dp[k] = new SC(k , k);
                    } else if (k < d){
                        dp[k] = dp[k];
                    } else {
                        dp[k] = findMin(dp[k], dp[k-d], j);
                    }
                }
//                dp = new_dp;
//                System.out.println(String.format("%d %d : %s", i, j, dp[target]));
            }
        }
        if(target >= 50){
            int d = 50;
            for(int k = d ; k <= target ; k++){
                dp[k] = findMin(dp[k], dp[k-d], 1);
            }
        }



        answer[0] = dp[target].totalCnt;
        answer[1] = dp[target].singleCnt;
        return answer;
    }

    private static SC findMin(SC left, SC right){
        if (left == null || left.totalCnt == 0){
            return right;
        } else if (right == null || right.totalCnt == 0){
            return left;
        }

        if(right.totalCnt < left.totalCnt){
            return right;
        } else if (right.totalCnt > left.totalCnt){
            return left;
        } else  if(right.singleCnt > left.singleCnt){
            return right;
        }
        return left;
    }

    private static SC findMin(SC left, SC right, int j) {
        SC n = null;
        if(right == null || (right.totalCnt == 0)){
            n =  new SC(1, j == 1 ? 1 : 0);
        } else {
            n = new SC(right.totalCnt + 1, right.singleCnt + (j == 1 ? 1 : 0));
        }

        if (left == null){
            return n;
        }

        if(n.totalCnt < left.totalCnt){
            return n;
        } else if (n.totalCnt > left.totalCnt){
            return left;
        } else  if(n.singleCnt > left.singleCnt){
            return n;
        }
        return left;
    }

    public static class SC {
        int totalCnt;
        int singleCnt;

        public SC(int totalCnt, int singleCnt){
            this.totalCnt = totalCnt;
            this.singleCnt = singleCnt;
        }

        public String toString(){
            return String.format("total : %d, single : %d", this.totalCnt, this.singleCnt);
        }
    }
}