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
    int k = Integer.parseInt(line[1]);

    P[][] path = new P[n][2];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");

        P p = new P(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
        path[i][0] = p;
        P p2 = new P(Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        path[i][1] = p2;

    }
    System.out.println(solution(n, k, path));
  }


  public static long solution(int n , int k, P[][] path) {
    long result = 0;
    long[][] dp = new long[n][k+1];

    if(path[0][0].time <= k) dp[0][path[0][0].time] = path[0][0].money;
    if(path[0][1].time <= k) dp[0][path[0][1].time] = Math.max(path[0][1].money, dp[0][path[0][1].time]);

    for(int i = 1; i < n; i++){
      P walk = path[i][0];
      P bike = path[i][1];
      for(int m = 1 ; m <= k ; m++){
        if(dp[i-1][m] > 0 && m + walk.time <= k){
          dp[i][m + walk.time] = Math.max(dp[i][m + walk.time], dp[i-1][m] + walk.money);
        }
        if(dp[i-1][m] > 0 && m + bike.time <= k){
          dp[i][m + bike.time] = Math.max(dp[i][m + bike.time], dp[i-1][m] + bike.money);
        }

      }
    }

    for(int i = 0; i <= k; i++){
      result = Math.max(result, dp[n-1][i]);
    }

    return result;
  }

  public static class P{
    int time;
    int money;

    public P(int time, int money){
      this.time = time;
      this.money = money;
    }
  }

}
