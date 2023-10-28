
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;

  public static void template() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    S = new StringBuilder(br.readLine());
    T = new StringBuilder(br.readLine());
    int T = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");
    long n = Integer.parseInt(split[0]);
    long m = Integer.parseInt(split[1]);
    List<Integer> arr = new ArrayList<>();
    Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).forEach(arr::add);
    System.out.println(solution( m, 0, Collections.max(arr), arr));
  }


  public static long solution( long m , long s , long e, List<Integer> arr) {

    if (s >= e) {
      return e;
    }

    long mid = (s + e) / 2;
    long sum = calculate(mid, arr);
    if(m <= sum){
      if(s == mid || e == mid){
        return mid;
      }
      return solution( m, mid, e, arr);
    } else{
      return solution( m, s, mid, arr);
    }
  }

  public static long calculate(long target, List<Integer> arr){
    long sum = 0;
    for (Integer integer : arr) {
      sum += Math.max(integer - target, 0);
    }
    return sum;
  }
}