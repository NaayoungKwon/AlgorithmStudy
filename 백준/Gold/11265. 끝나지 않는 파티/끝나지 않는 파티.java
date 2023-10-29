
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.swing.text.DateFormatter;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);
    int[][] partyLine = new int[n+1][n+1];
    for (int i = 1 ; i <= n ; i++){
      String[] split1 = br.readLine().split(" ");
      for(int j = 1 ; j <= n ; j++){
        partyLine[i][j] = Integer.parseInt(split1[j-1]);
      }
    }

    List<Node> arr = new ArrayList<>();
    for (int i = 0 ; i < m ; i++){
      String[] split1 = br.readLine().split(" ");
      arr.add(new Node(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]), Integer.parseInt(split1[2])));
    }
    solution(n, m, partyLine, arr);

  }


  public static void solution(int n, int m, int[][] partyLine, List<Node> arr) {
    Set<Integer> startSet = arr.stream().map(Node::getX).collect(Collectors.toSet());
    Map<Integer, List<Integer>> djikstraMap = new HashMap<>();

    startSet.forEach(start -> {
      List<Integer> djikstra = djikstra(n, start, partyLine);
      djikstraMap.put(start, djikstra);
    });

    arr.forEach(node -> {
      if(djikstraMap.get(node.x).get(node.y) <= node.time){
        System.out.println("Enjoy other party");
      } else{
        System.out.println("Stay here");
      }
    });
  }

  public static List<Integer> djikstra(int n, int start,  int[][] partyLine){
    PriorityQueue<Node> que = new PriorityQueue<>(Node::compareTo);
    int[] dist = new int[n+1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;

    que.add(new Node(start, start, 0));

    while(!que.isEmpty()){
      Node node = que.poll();
      if(dist[node.y] >= node.time){
        for(int j = 1 ; j <= n ; j++){
          if(j == start){
            continue;
          }
          if(dist[j] > node.time + partyLine[node.y][j]){
            dist[j] = node.time + partyLine[node.y][j];
            que.add(new Node(node.y, j, dist[j]));
          }
        }

      }

    }
    return Arrays.stream(dist).boxed().collect(Collectors.toList());
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

    public int getX(){
      return this.x;
    }

    public int getTime(){
      return this.time;
    }

    @Override
    public boolean equals(Object o){
      if(o instanceof Node){
        Node node = (Node) o;
        return this.x == node.x && this.y == node.y;
      }
      return false;
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