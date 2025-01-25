import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();


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


  public static int solution(int n ,int m, int[][] arr) {
    int result = Integer.MAX_VALUE;
    List<Node> cctvs = new ArrayList<>();

    for(int i = 0; i < n ; i++){
      for(int j = 0 ; j < m ; j++){
        if(arr[i][j] > 0 && arr[i][j] < 6){
          cctvs.add(new Node(i, j, arr[i][j]));
        }
      }
    }

    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    Queue<QN> queue = new LinkedList<>();
    queue.add(new QN(0, arr));

    while(!queue.isEmpty()){
      QN qn = queue.poll();
      int idx = qn.idx;
      int[][] prevMap = qn.map;


      if(idx == cctvs.size()){
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
          for(int j = 0 ; j < m ; j++){
            if(prevMap[i][j] == 0){
              cnt++;
            }
          }
        }
        result = Math.min(result, cnt);
        continue;
      }
      int type = cctvs.get(idx).type;
      if(type == 1){
        for(int i = 0 ; i < 4 ; i++){
          int[][] newMap = deepCopy(n, m, prevMap);
          int[] dir = dirs[i];
          for(int j = 1 ; j < 8 ; j++){
            int nx = cctvs.get(idx).x + dir[0] * j;
            int ny = cctvs.get(idx).y + dir[1] * j;
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || newMap[nx][ny] == 6){
              break;
            } else if (newMap[nx][ny] > 0 && newMap[nx][ny] < 6){
              continue;
            }
            newMap[nx][ny] = 7;
          }
          queue.add(new QN(idx + 1, newMap));
        }
      } else if (type == 2){
        for(int k = 0; k < 2 ; k++) {
          int[][] newMap = deepCopy(n, m, prevMap);
          for (int i = 0; i < 2; i++) {
            int[] dir = dirs[i*2 + k];
            for (int j = 1; j < 8; j++) {
              int nx = cctvs.get(idx).x + dir[0] * j;
              int ny = cctvs.get(idx).y + dir[1] * j;
              if (nx < 0 || ny < 0 || nx >= n || ny >= m || newMap[nx][ny] == 6) {
                break;
              } else if (newMap[nx][ny] > 0 && newMap[nx][ny] < 6) {
                continue;
              }
              newMap[nx][ny] = 7;
            }
          }
          queue.add(new QN(idx + 1, newMap));
        }
      } else if (type == 3){
        for(int k = 0; k < 4 ; k++) {
          int[][] newMap = deepCopy(n, m, prevMap);
          for (int i = k; i < k+2; i++) {
            int[] dir = dirs[(i)%4];
            for (int j = 1; j < 8; j++) {
              int nx = cctvs.get(idx).x + dir[0] * j;
              int ny = cctvs.get(idx).y + dir[1] * j;
              if (nx < 0 || ny < 0 || nx >= n || ny >= m || newMap[nx][ny] == 6) {
                break;
              } else if (newMap[nx][ny] > 0 && newMap[nx][ny] < 6) {
                continue;
              }
              newMap[nx][ny] = 7;
            }
          }
          queue.add(new QN(idx + 1, newMap));
        }
      } else if (type == 4){
        for(int k = 0; k < 4 ; k++) {
          int[][] newMap = deepCopy(n, m, prevMap);
          for (int i = k; i < k+3; i++) {
            int[] dir = dirs[(i)%4];
            for (int j = 1; j < 8; j++) {
              int nx = cctvs.get(idx).x + dir[0] * j;
              int ny = cctvs.get(idx).y + dir[1] * j;
              if (nx < 0 || ny < 0 || nx >= n || ny >= m || newMap[nx][ny] == 6) {
                break;
              } else if (newMap[nx][ny] > 0 && newMap[nx][ny] < 6) {
                continue;
              }
              newMap[nx][ny] = 7;
            }
          }
          queue.add(new QN(idx + 1, newMap));
        }
      } else if (type == 5){
        int[][] newMap = deepCopy(n, m, prevMap);
        for(int i = 0 ; i < 4 ; i++){
          int[] dir = dirs[i];
          for(int j = 1 ; j < 8 ; j++){
            int nx = cctvs.get(idx).x + dir[0] * j;
            int ny = cctvs.get(idx).y + dir[1] * j;
            if(nx < 0 || ny < 0 || nx >= n || ny >= m || newMap[nx][ny] == 6){
              break;
            } else if (newMap[nx][ny] > 0 && newMap[nx][ny] < 6){
              continue;
            }
            newMap[nx][ny] = 7;
          }
        }
        queue.add(new QN(idx + 1, newMap));
      }

    }

    return result;
  }

  private static int[][] deepCopy(int n, int m, int[][] prevMap) {
    int[][] newMap = new int[n][m];
    for(int j = 0 ; j < n; j++){
      newMap[j] = Arrays.copyOf(prevMap[j], m);
    }
    return newMap;
  }


  public static class QN{
    int idx;
    int[][] map;
    public QN(int idx, int[][] map){
      this.idx = idx;
      this.map = map;
    }
  }


  public static class Node{
    int x;
    int y;
    int type;

    public Node(int x, int y, int type){
      this.x = x;
      this.y = y;
      this.type = type;
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
