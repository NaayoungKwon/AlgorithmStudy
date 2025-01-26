import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;
  private static int minD = Integer.MAX_VALUE;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int k = Integer.parseInt(line[1]);
    int[][] pan = new int[n+1][n+1];
//    for(int i = 0 ; i < n+1 ; i++){
//      Arrays.fill(pan[i], Integer.MAX_VALUE);
//    }
//    int[] arr = new int[n];
//    Map<Integer, List<Path>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for(int j = 0 ; j < n ; j++){
        pan[i][j] = Integer.parseInt(split[j]);
//        if(pan[i+1][j+1] != 0){
//          List<Path> paths = map.getOrDefault(i+1, new ArrayList<>());
//          paths.add(new Path(j+1, pan[i+1][j+1]));
//          map.put(i+1, paths);
//        }
      }
    }

    System.out.println(solution(n, k , pan));
//    solution(n, map);
  }


  public static int solution(int n, int start, int[][] pan){
    int result = Integer.MAX_VALUE;
    boolean[] visited = new boolean[n];
    visited[start] = true;

    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        for(int k = 0 ; k < n ; k++){
         if(pan[i][j] > pan[i][k] + pan[k][j]){
           pan[i][j] = pan[i][k] + pan[k][j];
         }
        }
      }
    }

    return bt(n, start, pan, visited, 0, 0);
  }

  public static int bt(int n, int start, int[][] pan, boolean[] visited, int depth, int sum){
    if(depth == n-1){
      return sum;
    }
//    int result = Integer.MAX_VALUE;
    for(int i = 0 ; i < n ; i++){
      if(!visited[i]){
        visited[i] = true;
        minD = Math.min(minD, bt(n, i, pan, visited, depth+1, sum + pan[start][i]));
        visited[i] = false;
      }
    }
    return minD;

  }



}
