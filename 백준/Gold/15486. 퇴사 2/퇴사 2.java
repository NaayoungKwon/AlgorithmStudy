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
    int[][] pan = new int[n][2];
//    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < 2; j++) {
        pan[i][j] = Integer.parseInt(split[j]);
//        arr[j] = Integer.parseInt(split[j]);
//      }
      }
    }
    System.out.println(solution(n, pan));
  }


  public static int solution(int n , int[][] arr) {
    int result = 0;
    int[] dp = new int[n+1];

    if(arr[0][0] <= n ){
      dp[arr[0][0]] = arr[0][1];
    }

    for(int i = 1 ; i < n ; i ++){
      int day = i + arr[i][0];
      dp[i+1] = Math.max(dp[i], dp[i+1]);
      if(day > n){
        continue;
      }
      dp[day] = Math.max(dp[day], dp[i] + arr[i][1]);
    }
    for(int i = 0 ; i <= n ; i++){
      result = Math.max(result, dp[i]);
    }

    return result;
  }



}
