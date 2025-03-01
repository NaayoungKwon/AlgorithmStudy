import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int MAX_VALUE = 10000;
        int l = info.length;
        int[][] dp = new int[l][n+1];
        for(int i = 0 ; i < l ; i++){
            Arrays.fill(dp[i], MAX_VALUE);
        }
        if(info[0][1] < m){
            dp[0][0] = info[0][1];
        }
        if(info[0][0] < n){
            dp[0][info[0][0]] = 0;
        }

        for(int i = 1 ; i < l ; i++){
           for(int j = 0 ; j < n+1 ; j++){
               if(dp[i-1][j] == MAX_VALUE){
                   continue;
               }
               if(dp[i-1][j] + info[i][1] < m){ // b를 더함
                   dp[i][j] = Math.min(dp[i][j], dp[i-1][j] + info[i][1]);
               }
               if(j + info[i][0] < n) { // a를 더함
                   dp[i][j+info[i][0]] = Math.min(dp[i][j+info[i][0]], dp[i-1][j]);
               }

           }
        }
        for(int i = 0 ; i < n ; i++){
            if(dp[l-1][i] != MAX_VALUE){
                return i;
            }
        }

        return  -1;
    }
}