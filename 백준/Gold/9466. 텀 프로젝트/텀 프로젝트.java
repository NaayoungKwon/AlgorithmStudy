import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int i = 0 ; i < T ; i++){
      int n =Integer.parseInt(br.readLine());
      int[] arr = new int[n+1];
      String[] split = br.readLine().split(" ");
      for(int j = 1 ; j <= n ; j++){
        arr[j] = Integer.parseInt(split[j-1]);
      }
      System.out.println(solution(n, arr));
    }

  }


  public static int solution(int n, int[] arr) {
    int result = 0;
    Queue<Integer> zero = new ArrayDeque<>();
    int[] count = new int[n+1];
    Arrays.fill(count, 0);
    for(int i = 1 ; i <= n ; i++){
      count[arr[i]]++;
    }
    for(int i = 1 ; i <= n ; i++){
      if(count[i] == 0){
        zero.add(i);
      }
    }
    while(!zero.isEmpty()){
      Integer node = zero.poll();
      result += 1;
      count[arr[node]] -= 1;
      if(count[arr[node]] == 0){
        zero.add(arr[node]);
      }
    }

    return result;
  }




}