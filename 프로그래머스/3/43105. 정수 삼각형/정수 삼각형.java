import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        
        int answer = 0;
        int l = triangle[triangle.length - 1].length;
        int[][] dp = new int[triangle.length][l];

        dp[0][0] = triangle[0][0];
        for(int i = 1 ; i < l ; i++){
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; 
            for(int j = 1 ; j <= i ; j++){
                dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j], dp[i-1][j-1]);
            }
        }

        for(int i = 0; i < l; i++) {
            answer = Math.max(answer, dp[l - 1][i]);
        }

        return answer;
    }
}