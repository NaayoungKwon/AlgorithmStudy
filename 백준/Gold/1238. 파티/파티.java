import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {

  private static BufferedReader br;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int x = Integer.parseInt(line[2]);
    int[][] pan = new int[2][n];
//    int[] arr = new int[n];
    Map<Integer, List<Way>> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
      String[] split = br.readLine().split(" ");
      Way way = new Way(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
          Integer.parseInt(split[2]));
      List<Way> l = map.getOrDefault(way.s, new ArrayList<>());
         l.add(way);
          map.put(way.s, l);

//      for (int j = 0; j < n; j++) {
//        pan[i][j] = Integer.parseInt(split[j]);
//      }
//      }
    }
    System.out.println(solution(n, x, map));
  }


  public static int solution(int n , int x, Map<Integer, List<Way>> map) {
    int result = 0;
    int[] dist = new int[n+1];

    for(int i = 1 ; i <= n ; i++){
      if(i != x ){
        dist[i] += dj(n, i, map)[x];
      } else {
        int[] r = dj(n, i, map);
        for(int j = 1 ; j <= n ; j++){
          if(j != x){
            dist[j] += r[j];
          }
        }
      }
    }

    for(int i = 1 ; i <= n ; i++){
      if(i == x){
        continue;
      }
      result = Math.max(result, dist[i]);
    }

    return result;
  }

  public static int[] dj(int n, int start, Map<Integer, List<Way>> map){
    // initialize and fill to max
    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    PriorityQueue<Way> pq = new PriorityQueue<>((a,b) -> a.d - b.d);

    pq.add(new Way(start, start, 0));
    dist[start] = 0;

    while(!pq.isEmpty()){
      Way node = pq.poll();
      if(dist[node.e] < node.d){
        continue;
      }
      for(Way way : map.getOrDefault(node.e, new ArrayList<>())){
        int cost = node.d + way.d;
        if(cost < dist[way.e]){
          dist[way.e] = cost;
          pq.add(new Way(way.s, way.e, cost));
        }
      }
    }

    return dist;
  }


  public static class Way{
    int s;
    int e;
    int d;

    public Way(int s, int e, int d){
      this.s = s;
      this.e = e;
      this.d = d;
    }
  }


}
