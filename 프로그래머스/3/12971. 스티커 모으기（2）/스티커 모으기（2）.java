class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        // dp[이걸 땟을 때/안땟을 때][idx] = 최댓값
        int[][] dp = new int[2][n];

        // 첫 번째 것을 무조건 뜯었을 때
        dp[0][0] = 0;
        dp[1][0] = sticker[0];
        for(int i = 1 ; i < n-1 ; i++){
            int left = i-1;
            int right = (i + 1) % n;
            dp[0][i] = Math.max(dp[0][left], dp[1][left]);
            dp[1][i] = dp[0][left] + sticker[i];
        }
        if(n > 1){
            answer = Math.max(answer, dp[0][n-2]);
            answer = Math.max(answer, dp[1][n-2]);
        } else {
            answer = sticker[0];
        }
        

        // 첫 번째 것을 안 뜯었을 때
        int[][] dp2 = new int[2][n];
        for(int i = 1 ; i < n ; i++){
            int left = i-1;
            dp2[0][i] = Math.max(dp2[0][left], dp2[1][left]);
            dp2[1][i] = dp2[0][left] + sticker[i];
        }
        answer = Math.max(answer, dp2[0][n-1]);
        answer = Math.max(answer, dp2[1][n-1]);

        return answer;
    }
}