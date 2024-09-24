class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int h = triangle.length;
        int[][] dp = new int[h][h];
        
        dp[0][0] = triangle[0][0];
        for(int i = 1 ; i < h ; i++){
            for(int j = 0 ; j <= i ; j++){
                int m = 0;
                if(j > 0 && j < i){
                    m = Math.max(dp[i-1][j-1], dp[i-1][j]);
                } else if (j == 0){
                    m = dp[i-1][j];
                } else if (j == i){
                     m = dp[i-1][j-1];
                }
                dp[i][j] = m + triangle[i][j];
            }
        }
        
        for(int i = 0 ; i < h ; i ++){
            answer = Math.max(answer, dp[h-1][i]);
        }
        return answer;
    }
}