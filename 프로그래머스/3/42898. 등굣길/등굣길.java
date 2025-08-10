import java.util.*;
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n+1][m+1];
        int[][] map_ = new int[n+1][m+1];
        for(int[] puddle : puddles){
            map_[puddle[1]][puddle[0]] = -1; // 물웅덩이
        }

        for(int i = 1 ; i <= n ; i++){
            if(map_[i][1] != -1){
                dp[i][1] = 1;
            } else {
                break;
            }
        }
        for(int i = 1 ; i <= m ; i++){
            if(map_[1][i] != -1){
                dp[1][i] = 1;
            } else {
                break;
            }
        }
        for(int i = 2 ; i <= n ; i++){
            for(int j = 2 ; j <= m ; j++){
                int top = map_[i-1][j] == -1 ? 0 : dp[i-1][j];
                int left = map_[i][j-1] == -1 ? 0 : dp[i][j-1];
                dp[i][j] = (map_[i][j] == -1 ? 0 : top + left) % 1_000_000_007;
            }

        }
        return dp[n][m];
    }
}