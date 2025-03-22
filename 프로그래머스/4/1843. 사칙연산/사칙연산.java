import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int n = arr.length/2 + 1;
        int[][][] dp = new int[n+1][n+1][2];

        for (int i = 0; i < n; i++) {
            dp[i][i][0] = Integer.valueOf(arr[i*2]);
            dp[i][i][1] = Integer.valueOf(arr[i*2]);
        }

        for(int k = 1 ; k < n ; k++){
            for (int i = 0; i + k < n; i++) {
                int a = i + k;
                int maxM = Integer.MIN_VALUE;
                int minM = Integer.MAX_VALUE;

                for(int b = i ; b < a ; b++){
                    int left = dp[i][b][0];
                    int left2 = dp[i][b][1];
                    int right = dp[b+1][a][0];
                    int right2 = dp[b+1][a][1];

                    maxM = Math.max(maxM,  arr[1+ 2*b].equals("-") ? left - right : left + right);
                    minM = Math.min(minM,  arr[1+ 2*b].equals("-") ? left - right : left + right);

                    maxM = Math.max(maxM,  arr[1+ 2*b].equals("-") ? left2 - right : left2 + right);
                    minM = Math.min(minM,  arr[1+ 2*b].equals("-") ? left2 - right : left2 + right);

                    maxM = Math.max(maxM,  arr[1+ 2*b].equals("-") ? left - right2 : left + right2);
                    minM = Math.min(minM,  arr[1+ 2*b].equals("-") ? left - right2 : left + right2);

                    maxM = Math.max(maxM,  arr[1+ 2*b].equals("-") ? left2 - right2 : left2 + right2);
                    minM = Math.min(minM,  arr[1+ 2*b].equals("-") ? left2 - right2 : left2 + right2);

                }
                dp[i][a][0] = minM;
                dp[i][a][1] = maxM;

            }
        }



        return dp[0][n-1][1];
    }
}