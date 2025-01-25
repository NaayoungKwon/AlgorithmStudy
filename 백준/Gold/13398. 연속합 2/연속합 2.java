import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

  private static BufferedReader br;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
//    int m = Integer.parseInt(line[1]);
//    int[][] pan = new int[n][m];
    int[] arr = new int[n];
//    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for(int j = 0 ; j < n ; j++){
//        pan[i][j] = Integer.parseInt(split[j]);
        arr[j] = Integer.parseInt(split[j]);
//      }
    }

    System.out.println(solution(n, arr));
  }


  public static int solution(int n , int[] arr) {
    int result = 0;
    int[][] dp = new int[2][n];
    boolean plus = false;

    dp[0][0] =  arr[0];
    for(int i = 1; i < n ; i++){
      if(arr[i] > 0){
        plus = true;
      }
      dp[0][i] = Math.max(dp[0][i-1] + arr[i], arr[i]);
      if(dp[1][i-1] != 0){
        dp[1][i] = dp[1][i-1] + arr[i];
      }
      if(arr[i] < 0){
        dp[1][i] = Math.max(dp[1][i-1] + arr[i], Math.max(0,dp[0][i-1]));
      }
    }
    // fin max in dp
    for(int i = 0 ; i < n ; i++){
      result = Math.max(result, Math.max(dp[0][i], dp[1][i]));
    }
    if(!plus){
      int max = Integer.MIN_VALUE;
      for(int i = 0 ; i  < n ; i++){
        max = Math.max(max, arr[i]);
      }
      result = max;
    }

    return result;
  }


}
