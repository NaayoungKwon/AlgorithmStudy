import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int l = money.length;

        int[][] dp1 = new int[2][l];
        int[][] dp2 = new int[2][l];
        dp1[0][0] = money[0];
        dp1[1][0] = 0;

        dp2[1][0] = 0;
        dp2[0][0] = 0;

        for(int i = 1; i < l ; i++){
            dp1[0][i] = dp1[1][i-1] + money[i];
            dp1[1][i] = Math.max(dp1[0][i-1], dp1[1][i-1]);

            dp2[0][i] = dp2[1][i-1] + money[i];
            dp2[1][i] = Math.max(dp2[0][i-1], dp2[1][i-1]);
        }

        return Math.max(dp1[1][l-1],Math.max(dp2[0][l-1], dp2[1][l-1]));
    }
}