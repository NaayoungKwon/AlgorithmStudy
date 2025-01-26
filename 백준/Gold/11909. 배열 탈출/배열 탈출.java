import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

  private static BufferedReader br;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);

    int[][] pan = new int[n][n];

    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        pan[i][j] = Integer.parseInt(split[j]);
      }
    }
    System.out.println(solution(n, pan));
  }


  public static int solution(int n , int[][] arr) {
    int result = Integer.MAX_VALUE;
    int[][] dp = new int[n][n];
    for(int i = 0 ; i < n ; i++){
      Arrays.fill(dp[i], Integer.MAX_VALUE);
    }

    dp[0][0] = 0;
    for(int i = 0 ; i < n ; i++){
      for(int k = 0 ; k < n ; k++){
        if(i == 0 && k == 0){
          continue;
        }

        if(i > 0){
          if(arr[i-1][k] <= arr[i][k] ){
            dp[i][k] = Math.min(dp[i][k], dp[i-1][k] + arr[i][k] - arr[i-1][k] + 1);
          } else {
            dp[i][k] = Math.min(dp[i][k], dp[i-1][k]);
          }
        }

        if(k > 0) {
          if(arr[i][k-1] <= arr[i][k]){
            dp[i][k] = Math.min(dp[i][k], dp[i][k-1] + arr[i][k] - arr[i][k-1] + 1);
          } else {
            dp[i][k] = Math.min(dp[i][k], dp[i][k-1]);
          }
        }
      }
    }

    return dp[n-1][n-1];
  }

}
