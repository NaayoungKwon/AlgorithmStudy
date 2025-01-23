class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n+1][n];
        dp[0][0] = triangle[0][0];
        for(int i = 0 ; i < n-1 ; i++){
            for(int j = 0; j <= i ; j++ ){
                // 7 기준에서 밑에 왼쪽꺼랑 합친거랑, 밑에 왼쪽에 원래 있던거랑 비교해서 넣어
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }
        for(int i = 0 ; i < n ; i++){
            answer = Math.max(answer, dp[n-1][i]);
        }
        return answer;
    }
}