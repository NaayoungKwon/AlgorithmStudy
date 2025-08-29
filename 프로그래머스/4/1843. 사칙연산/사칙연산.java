import java.util.*;
class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] dp2 = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            Arrays.fill(dp2[i], Integer.MAX_VALUE);
        }
        

        // 자기 자신들은 초기화
        for(int i = 0 ; i < n ; i += 2){
            dp[i][i] = Integer.valueOf(arr[i]);
            dp2[i][i] = Integer.valueOf(arr[i]);
        }

        // 두개를 비교하는 것 부터, 전체를 다 비교하는 것까지 진행한다.
        for(int len = 2; len <= n ; len++){
            // 오른쪽 대각선으로 움직이자
            for(int start = 0; start + (len-1)*2 < n; start +=2){
                int end = start + (len-1)*2;
                for(int mid = start; mid+2 <= end; mid += 2){
                    // System.out.println("dp[" + start + "][" + end + "] = max(dp[" + start + "][" + mid + "]_" + dp[start][mid] + ", dp[" + (mid+2) + "][" + end + "]_" +dp[mid+2][end] + ", " + arr[mid+1] + ")");
                    dp[start][end] = Math.max(dp[start][end], operateMax(dp2[start][mid], dp2[mid+2][end],dp[start][mid], dp[mid+2][end], arr[mid+1]));
                    dp2[start][end] = Math.min(dp2[start][end], operateMin(dp2[start][mid], dp2[mid+2][end], dp[start][mid], dp[mid+2][end], arr[mid+1]));
                }
                // System.out.println("dp[" + start + "][" + end + "] = " + dp[start][end]);
            }

        }
        return Math.max(dp[0][n-1], dp2[0][n-1]);
    }
    
    public int operateMin(int maxA, int maxB, int minA, int minB, String op){
        if(op.equals("+")){
            
            return Math.min(maxA, minA)+ Math.min(maxB, minB);
        }
        
        return Math.min(maxA, minA) - Math.max(maxB, minB);
    }
    
    public int operateMax(int maxA, int maxB, int minA, int minB, String op){
        if(op.equals("+")){
            return Math.max(maxA, minA) + Math.max(maxB, minB);
        }
        return Math.max(maxA, minA) - Math.min(maxB, minB);
    }
}