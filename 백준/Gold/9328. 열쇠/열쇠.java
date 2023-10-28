
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

    for (int a = 0 ; a < T ; a++) {
      String[] line = br.readLine().split(" ");
      int n = Integer.parseInt(line[0]);
      int m = Integer.parseInt(line[1]);
      char[][] pan = new char[n][m];
      for (int i = 0; i < n; i++) {
        pan[i] = br.readLine().toCharArray();
      }
      String s = br.readLine();
      Set<String> keys = new HashSet<>();
      if (!(s.length() == 1 && s.charAt(0) == '0')) {
        keys.addAll(Arrays.stream(s.split("")).collect(Collectors.toSet()));
      }

      solution(n, m, pan, keys);
    }
  }


  public static void solution(int n , int m, char[][] pan, Set<String> keys) {
    AtomicInteger result = new AtomicInteger();

    List<Node> entries = new ArrayList<>();
    Map<String, List<Node>> door = new HashMap<>();

    List<Node> walls = new ArrayList<>();
    for(int j = 0 ; j < m ; j++){
      walls.add(new Node(0, j));
      walls.add(new Node(n-1, j));
    }
    for(int i = 1 ; i < n-1 ; i++){
      walls.add(new Node(i,0));
      walls.add(new Node(i,m-1));
    }

    walls.forEach(wall -> {
      int i = wall.x;
      int j = wall.y;
      if(isEntry(pan[i][j])){
        entries.add(new Node(i, j));
      }

      if (Character.isLowerCase(pan[i][j])) {
        keys.add(String.valueOf(pan[i][j]));
      } else if (Character.isUpperCase(pan[i][j])) {
        List<Node> d = door.getOrDefault(String.valueOf(pan[i][j]), new ArrayList<>());
        d.add(new Node(i, j));
        door.put(String.valueOf(pan[i][j]), d);
      } else if (pan[i][j] == '$'){
        result.addAndGet(1);
        pan[i][j] = '.';
      }
    });


    keys.forEach(key -> {
      if(door.containsKey(key.toUpperCase())){
        List<Node> nodes = door.get(key.toUpperCase());
        entries.addAll(nodes);
      }
    });

    boolean[][] visited = new boolean[n][m];

    Queue<Node> que = new ArrayDeque<>(entries);
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    while(!que.isEmpty()) {
      Node cur = que.poll();
      visited[cur.x][cur.y] = true;

      for (int i = 0; i < 4; i++) {
        int nx = cur.x + dx[i];
        int ny = cur.y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m || (visited[nx][ny])|| pan[nx][ny] == '*')
          continue;

        visited[nx][ny] = true;
        if (Character.isLowerCase(pan[nx][ny])) {
          keys.add(String.valueOf(pan[nx][ny]));
          if(door.containsKey(String.valueOf(pan[nx][ny]).toUpperCase())){
            List<Node> nodes = door.get(String.valueOf(pan[nx][ny]).toUpperCase());
            que.addAll(nodes);
          }
        } else if (pan[nx][ny] == '$') {
          result.addAndGet(1);
        } else if (Character.isUpperCase(pan[nx][ny])){
          List<Node> d = door.getOrDefault(String.valueOf(pan[nx][ny]), new ArrayList<>());
          d.add(new Node(nx, ny));
          door.put(String.valueOf(pan[nx][ny]), d);
          if(!keys.contains(String.valueOf(pan[nx][ny]).toLowerCase())){
            continue;
          }
        }
        que.add(new Node(nx, ny));
      }
    }

    System.out.println(result.get());
  }


  public static boolean isEntry(char c){
    return c == '.' || Character.isLowerCase(c) || c == '$';
  }

  public static class Node{
    int x;
    int y;
    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }
  }


}