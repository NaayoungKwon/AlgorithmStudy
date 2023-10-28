
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

    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int[][] pan = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] split = br.readLine().split(" ");
      for(int j = 0 ; j < m ; j++){
        pan[i][j] = Integer.parseInt(split[j]);
      }
    }

    System.out.println(solution(n, m, pan));

  }


  public static int solution(int n , int m, int[][] pan) {

    List<Node> cheeses = new ArrayList<>();
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < m ; j++){
        if(pan[i][j] == 1){
          cheeses.add(new Node(i, j));
        }
      }
    }
    int day = 0;
    while(!cheeses.isEmpty()){
      List<Node> willBeMelted = new ArrayList<>();
      List<Node> airSpaces = new ArrayList<>();
      Queue<Node> queue = new ArrayDeque<>();
      boolean[][] visited = new boolean[n][m];

      Node start = firstAirSpace(pan);
      queue.add(start);
      visited[start.x][start.y] = true;
      while(!queue.isEmpty()){
        Node node= queue.poll();
        airSpaces.add(node);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for(int i = 0 ; i  <4 ; i++){
          int nx = node.x + dx[i];
          int ny = node.y + dy[i];
          if(nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) continue;
          if(pan[nx][ny] <= 0){
            queue.add(new Node(nx, ny));
            visited[nx][ny] = true;
          }
        }
      }

      airSpaces.forEach(airSpace -> pan[airSpace.x][airSpace.y] = -1);

      // 없어질 치즈 찾기
      for(Node cheese : cheeses){
        int x = cheese.x;
        int y = cheese.y;
        int count = 0;
        if(x-1 >= 0 && pan[x-1][y] == -1){
          count++;
        }
        if(x+1 < n && pan[x+1][y] == -1){
          count++;
        }
        if(y-1 >= 0 && pan[x][y-1] == -1){
          count++;
        }
        if(y+1 < m && pan[x][y+1] == -1){
          count++;
        }
        if(count >= 2){
          willBeMelted.add(cheese);
        }
      }

      // cheeses에서 willBeMelted 제거
      for(Node cheese : willBeMelted){
        cheeses.remove(cheese);
        pan[cheese.x][cheese.y] = 0;
      }
      day += 1;
    }

    return day;
  }

  public static Node firstAirSpace(int[][] pan){
    for(int i = 0 ; i < pan.length ; i++){
      for(int j = 0 ; j < pan[0].length ; j++){
        if(pan[i][j] == 0){
          return new Node(i, j);
        }
      }
    }
    return null;
  }

  public static class Node{
    int x;
    int y;

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o){
      if(o instanceof Node){
        Node node = (Node) o;
        return this.x == node.x && this.y == node.y;
      }
      return false;
    }
  }


}