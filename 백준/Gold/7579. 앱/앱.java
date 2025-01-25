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
    int m = Integer.parseInt(line[1]);
    int[][] pan = new int[2][n];
//    int[] arr = new int[n];
    for (int i = 0; i < 2; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < n; j++) {
        pan[i][j] = Integer.parseInt(split[j]);
      }
//      }
    }
    System.out.println(solution(n, m, pan));
  }


  public static int solution(int n , int m, int[][] pan) {
    int result = 0;

    int[][] dp = new int[n][10001];
    dp[0][pan[1][0]] = pan[0][0];

    for(int i = 1 ; i < n ; i++){
      dp[i][pan[1][i]] = pan[0][i];
      for(int k = 0; k < 10001; k++){
        dp[i][k] = Math.max(dp[i][k], dp[i-1][k]);
        int next = k + pan[1][i];
        if(next <= 10001 && dp[i-1][k] != 0){
          dp[i][next] = Math.max(dp[i][next], dp[i-1][k] + pan[0][i]);
        }
      }
    }

    for (int i = 0; i <= 10001; i++) {
      if(dp[n-1][i] >= m){
        result = i;
        break;
      }
    }


    return result;
  }

}
