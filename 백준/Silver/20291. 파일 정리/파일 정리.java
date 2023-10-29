
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

    int n = Integer.parseInt(br.readLine());
    List<String> arr = new ArrayList<>();
    for (int i = 0 ; i < n ; i++){
        arr.add(br.readLine());
    }
    solution(arr);
  }


  public static void solution(List<String> arr) {
    int result = 0;
    Map<String, Integer> dic = new HashMap<>();
    arr.forEach(file -> {
      String[] split = file.split("\\.");
      Integer count = dic.getOrDefault(split[1], 0);
      dic.put(split[1], count + 1);
    });

    dic.keySet().stream().sorted().forEach(key -> {
      System.out.println(key + " " + dic.get(key));
    });
  }



}