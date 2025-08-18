import java.util.*;
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        int n = sticker.length;
        int[][] dp = new int[2][n];
        int[][] dp2 = new int[2][n];

        // dp : 안붙임, dp2 : 첫 번째 붙임
        dp[0][0] = 0;
        dp[1][0] = 0;
        dp2[0][0] = 0;
        dp2[1][0] = sticker[0];

        for(int i = 1 ; i < n ; i++){
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
            dp[1][i] = dp[0][i-1] + sticker[i];

            dp2[0][i] = Math.max(dp2[0][i-1], dp2[1][i-1]);
            dp2[1][i] = dp2[0][i-1] + sticker[i];
        }
        dp2[1][n-1] = 0;

        return n > 1 ? Math.max(dp2[0][n-1], Math.max(dp[1][n-1], dp[0][n-1])) : sticker[0];
    }
}