import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  private static BufferedReader br;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
//    int m = Integer.parseInt(line[1]);
    int[][] pan = new int[n][3];
//    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for (int j = 0; j < 3; j++) {
        pan[i][j] = Integer.parseInt(split[j]);
//        arr[j] = Integer.parseInt(split[j]);
//      }
      }
    }
    solution(n, pan);
  }


  public static void solution(int n , int[][] arr) {
    int mx = 0, minx = Integer.MAX_VALUE;
    int[][] dp = new int[n][3];

    dp[0][0] = arr[0][0];
    dp[0][1] = arr[0][1];
    dp[0][2] = arr[0][2];
    for(int i = 1; i < n ; i++){
      dp[i][0] = arr[i][0] + Math.max(dp[i-1][0], dp[i-1][1]);
      dp[i][1] = arr[i][1] + Math.max(dp[i-1][2] , Math.max(dp[i-1][0], dp[i-1][1]));
      dp[i][2] = arr[i][2] + Math.max(dp[i-1][2], dp[i-1][1]);
    }
    mx = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));

    for(int i = 1; i < n ; i++){
      dp[i][0] = arr[i][0] + Math.min(dp[i-1][0], dp[i-1][1]);
      dp[i][1] = arr[i][1] + Math.min(dp[i-1][2] , Math.min(dp[i-1][0], dp[i-1][1]));
      dp[i][2] = arr[i][2] + Math.min(dp[i-1][2], dp[i-1][1]);
    }
    minx = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));


    System.out.println(String.format("%d %d", mx, minx));
  }

}
