import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {

  private static BufferedReader br;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int[][] pan = new int[n][n];
//    int[] arr = new int[n];
    Map<Integer, List<Path>> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      List<Path> sway = map.getOrDefault(i, new ArrayList<>());
      for(int j = 0; j < n; j++){
        if(i == j){
          continue;
        }
        int d = Integer.parseInt(split[j]);
        sway.add(new Path(j, d));
      }
      map.put(i, sway);
//      }
    }

    List<Way> customers = new ArrayList<>();
    for(int i = 0 ; i < m ; i++){
      String[] split = br.readLine().split(" ");
      int s = Integer.parseInt(split[0]);
      int e = Integer.parseInt(split[1]);
      int d = Integer.parseInt(split[2]);
      customers.add(new Way(s-1, e-1, d));

    }
//    System.out.println(solution(n, m , map, customers));
    solution(n, m, map, customers);
  }


  public static void solution(int n, int m, Map<Integer, List<Path>> map, List<Way> customers){
    int result = Integer.MAX_VALUE;
    Map<Integer, int[]> dists = new HashMap<>();

    for(int i : customers.stream().map(a -> a.s).collect(Collectors.toSet())){
      int[] dist = dijkstra(n, i, map);
      dists.put(i, dist);
    }

    for(Way customer : customers){
      int[] dist = dists.get(customer.s);
      dists.put(customer.s, dist);
    }

    for(Way c : customers){
      if(dists.get(c.s)[c.e] <= c.d){
        System.out.println("Enjoy other party");
      } else {
        System.out.println("Stay here");
      }
    }

  }

  public static int[] dijkstra(int n, int start, Map<Integer, List<Path>> map){
    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    PriorityQueue<Path> pq = new PriorityQueue<>((a,b) -> a.d - b.d);

    pq.add(new Path( start, 0));
    dist[start] = 0;

    while(!pq.isEmpty()){
      Path node = pq.poll();
      if(dist[node.e] < node.d){
        continue;
      }
      for(Path way : map.getOrDefault(node.e, new ArrayList<>())){
        int cost = node.d + way.d;
        if(cost < dist[way.e]){
          dist[way.e] = cost;
          pq.add(new Path(way.e, cost));
        }
      }
    }

    return dist;
  }



  public static class Path{
    int e;
    int d;

    public Path(int e, int d){
      this.e = e;
      this.d = d;
    }

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
