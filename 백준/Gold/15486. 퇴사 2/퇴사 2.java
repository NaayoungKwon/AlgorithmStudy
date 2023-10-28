
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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    List<Integer> t = new ArrayList<>(n);
    List<Integer> p = new ArrayList<>(n);

    for(int i = 0 ; i < n ; i ++){
      String[] line = br.readLine().split(" ");
      t.add(Integer.parseInt(line[0]));
      p.add(Integer.parseInt(line[1]));
    }

    System.out.println(solution(n, t, p));
  }


  public static int solution(int n , List<Integer> t, List<Integer> p) {
    List<Integer> dp = new ArrayList<>(n+1);
    for(int i = 0 ; i <= n ; i++){
      dp.add(0);
    }

    int maxHistory = 0;
    for(int i = 0 ; i < n ; i++){
      maxHistory = Math.max(maxHistory, dp.get(i));
      int day = i + t.get(i);
      if(day <= n && maxHistory + p.get(i) > dp.get(day)){
        dp.set(day, maxHistory + p.get(i));
      }
    }

    return dp.stream().max(Integer::compareTo).orElse(0);
  }
}