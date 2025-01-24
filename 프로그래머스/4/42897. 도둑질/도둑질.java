import java.util.*;

class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int[][] dpAdd = new int[2][money.length];
        int[][] dpSkip = new int[2][money.length];

        dpAdd[1][0] = money[0];

        for(int i = 1 ; i < money.length ; i++){
          dpAdd[0][i] = Math.max(dpAdd[0][i-1], dpAdd[1][i-1]);
          dpAdd[1][i] = dpAdd[0][i-1] + money[i];

          dpSkip[0][i] = Math.max(dpSkip[0][i-1], dpSkip[1][i-1]);
          dpSkip[1][i] = dpSkip[0][i-1] + money[i];
        }
        answer = Math.max(dpSkip[0][money.length - 1], dpSkip[1][money.length - 1]);
        return Math.max(answer, dpAdd[0][money.length - 1]);
    }
}