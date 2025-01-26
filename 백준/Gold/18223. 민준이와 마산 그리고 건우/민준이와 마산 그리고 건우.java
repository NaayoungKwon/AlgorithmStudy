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
    int v = Integer.parseInt(line[0]);
    int e = Integer.parseInt(line[1]);
    int p = Integer.parseInt(line[2]);
//    int[][] pan = new int[v+1][v+1];
//    int[] arr = new int[n];
    Map<Integer, List<Path>> map = new HashMap<>();
    for (int i = 0; i < e; i++) {
      String[] split = br.readLine().split(" ");
      int s = Integer.parseInt(split[0]);
      int e1 = Integer.parseInt(split[1]);
      int d = Integer.parseInt(split[2]);
      List<Path> sway = map.getOrDefault(s, new ArrayList<>());
      List<Path> eway = map.getOrDefault(e1, new ArrayList<>());
      sway.add(new Path(e1, d));
      eway.add(new Path(s, d));
      map.put(s, sway);
      map.put(e1, eway);

//      }
    }
    System.out.println(solution(v,p , map));
  }


  public static String solution(int v , int p, Map<Integer, List<Path>> map){
    int result = Integer.MAX_VALUE;
    if(p == 1 || p == v){
      return "SAVE HIM";
    }

    int[] start = dijkstra(v, 1, map);
    int[] pd = dijkstra(v, p, map);
    if(start[v] == start[p] + pd[v]){
      return "SAVE HIM";
    }
    return "GOOD BYE";
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



}
