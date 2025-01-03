import java.io.*;
import java.util.*;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n+2];
    String[] split = br.readLine().split(" ");
    for(int j = 1 ; j <= n ; j++){
      arr[j] = Integer.parseInt(split[j-1]);
    }


    solution(n, arr);
  }



  public static void solution(int n ,int[] arr) {

    int[] lgdc = new int[n+2];
    int[] rgdc = new int[n+2];

    for(int i = 1 ; i <= n ; i++){
      lgdc[i] = gdc(lgdc[i-1], arr[i]);
    }

    for(int i = n; i > 0 ; i--){
      rgdc[i] = gdc(rgdc[i+1], arr[i]);
    }

    int max = -1, maxIdx = -1;

    for(int i = 1; i <= n ; i++){
      int q = gdc(lgdc[i-1], rgdc[i+1]);
      if(q > max && arr[i] % q != 0){
        max = q;
        maxIdx = i;
      }
    }

    if(max > 0) {
      System.out.printf("%d %d\n", max, arr[maxIdx]);
    } else {
      System.out.println(-1);
    }


  }

  private static int gdc(int a, int b) {
    if(b == 0){
      return a;
    } else if (a == 0) {
      return b;
    }
    return gdc(b, a%b);
  }
}