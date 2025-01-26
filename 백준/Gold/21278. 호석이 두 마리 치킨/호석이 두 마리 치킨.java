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
  private static int minD = Integer.MAX_VALUE;
  private static int[] result = new int[2];
  private static int[][] dists;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int[][] pan = new int[n+1][n+1];
    for(int i = 0 ; i < n+1 ; i++){
      Arrays.fill(pan[i], Integer.MAX_VALUE);
    }
//    int[] arr = new int[n];
//    Map<Integer, List<Path>> map = new HashMap<>();
    for (int i = 0; i < m; i++) {
      String[] split = br.readLine().split(" ");
      int a = Integer.parseInt(split[0]);
      int b = Integer.parseInt(split[1]);
        pan[a][b] = 1;
        pan[b][a] = 1;
    }

//    System.out.println(solution(n, m , map, customers));
    solution(n, pan);
  }


  public static void solution(int n, int[][] pan){
//    int result = Integer.MAX_VALUE;
    dists = new int[n+1][n+1];
    for(int i = 1 ; i <= n ; i++){
      dists[i] = djikstra(n, i, pan);
    }
    combination(new int[2], 0, n, 2, 0);
    System.out.println(String.format("%d %d %d", result[0], result[1], minD*2));
  }

  /**
   *  1 ~ n
   * */
  public static int[] djikstra(int n, int start,  int[][] map){
    PriorityQueue<Node> que = new PriorityQueue<>(Node::compareTo);
    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    que.add(new Node(start, start, 0));

    while(!que.isEmpty()){
      Node node = que.poll();
      if(dist[node.y] >= node.time){
        for(int j = 1 ; j <= n ; j++){
          if(j == start || j == node.x || j == node.y || map[node.y][j] == Integer.MAX_VALUE){
            continue;
          }
          if(dist[j] > node.time + map[node.y][j]){
            dist[j] = node.time + map[node.y][j];
            que.add(new Node(node.y, j, dist[j]));
          }
        }

      }

    }
    return dist;
//    return Arrays.stream(dist).boxed().collect(Collectors.toList());
  }

  public static void combination(int[] arr, int index, int n, int r, int target) {
    if (r == 0){
//      System.out.println(Arrays.toString(arr));
      int  x = Math.min(arr[0],arr[1])+1, y = Math.max(arr[0], arr[1])+1;
      int d = 0;
      for(int i = 1 ; i <= n ; i++){
        if(i == x || i == y){
          continue;
        }
        d += Math.min(dists[x][i], dists[y][i]);
      }
      if(minD > d){
        minD = d;
        result[0] = x;
        result[1] = y;
      } else if (minD == d){
        if(result[0] > x){
          result[0] = x;
          result[1] = y;
        } else if(result[0] == x){
          result[1] = Math.min(result[1], y);
        }
      }
      return;
    } else if (target == n){
      return;
    } else {
      arr[index] = target;
      combination(arr, index + 1, n, r - 1, target + 1);
      combination(arr, index, n, r, target + 1);
    }
  }




  public static class Node{
    int x;
    int y;
    int time;

    public Node(int x, int y, int time){
      this.x = x;
      this.y = y;
      this.time = time;
    }

    @Override
    public boolean equals(Object o){
      if(o instanceof Node){
        Node node = (Node) o;
        return this.x == node.x && this.y == node.y;
      }
      return false;
    }

    @Override
    public int hashCode(){
      return x * 1000 + y;
    }

    public int compareTo(Node p) {

      if(this.time < p.time){
        return -1;
      } else{
        return 1;
      }
    }
  }
}
