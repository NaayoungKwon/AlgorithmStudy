import java.io.*;

import java.util.*;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for(int i = 0 ; i < n ; i++){
      String[] split = br.readLine().split(" ");
      for(int j = 0 ; j < n ; j++){
        arr[i][j] = Integer.parseInt(split[j]);
      }
    }

    solution(n, arr);
  }



  public static void solution(int n ,int[][] arr) {
    List<Set<Node>> group = new ArrayList<>();
    boolean[][] visited = new boolean[n][n];
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        List<Node> queue = new LinkedList<>();
        if(arr[i][j] == 1 && !visited[i][j]){
          Set<Node> set = new HashSet<>();
          set.add(new Node(i, j));
          visited[i][j] = true;
          queue.add(new Node(i, j));
          while(!queue.isEmpty()){
            Node node = queue.get(0);
            queue.remove(0);
            for(int[] dir : dirs){
              int x = node.x + dir[0];
              int y = node.y + dir[1];
              if(x >= 0 && y >= 0 && x < n && y < n && arr[x][y] == 1 && !visited[x][y]){
                visited[x][y] = true;
                set.add(new Node(x, y));
                queue.add(new Node(x, y));
              }
            }
          }
          group.add(set);
        }
      }
    }

    int min = Integer.MAX_VALUE;
    

    for(int i = 0 ; i < group.size() ; i++){
      Set<Node> set = group.get(i);
      
      for(Node now : set){
        visited = new boolean[n][n];
        visited[now.x][now.y] = true;
        List<Node> queue = new LinkedList<>();
        queue.add(now);
        boolean flag = true;
        while(!queue.isEmpty() && flag){
          Node node = queue.get(0);
          queue.remove(0);
          for(int[] dir : dirs){
            int x = node.x + dir[0];
            int y = node.y + dir[1];
            if (x < 0 || y < 0 || x >= n || y >= n) {
              continue;
            }

            if(arr[x][y] == 0 && !visited[x][y]){
              visited[x][y] = true;
              queue.add(new Node(x, y));
            } else if (arr[x][y] == 1 && !set.contains(new Node(x, y))){
              min = Math.min(min, Math.abs(now.x - x) + Math.abs(now.y - y) - 1);
              flag = false;
              break;
            }
          }
        }
      }
    }
    System.out.println(min);
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

    @Override
    public int hashCode(){
      return x * 1000 + y;
    }
  }
}