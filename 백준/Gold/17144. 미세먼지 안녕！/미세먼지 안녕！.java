
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

    String[] split = br.readLine().split(" ");
    int r = Integer.parseInt(split[0]);
    int c = Integer.parseInt(split[1]);
    int t = Integer.parseInt(split[2]);

    int[][] pan = new int[r][c];
    for (int i = 0 ; i < r ; i++){
      String[] splitPan = br.readLine().split(" ");
      for(int j = 0 ; j < c ; j++){
        pan[i][j] = Integer.parseInt(splitPan[j]);
      }
    }
    System.out.println(solution(r,c, t, pan));
  }


  public static int solution(int r, int c, int t, int[][] pan) {
    int result = 0;

    // 공기청정기 위치 찾기
    List<Node> aircon = new ArrayList<>();
    for(int i = 0 ; i < r ; i++){
      for(int j = 0 ; j < c ; j++){
        if(pan[i][j] == -1){
          aircon.add(new Node(i,j));
        }
      }
    }


    for(int p = 0 ; p < t ; p++){
      // 순회하면서 인접한 방향에 확산되는 먼지들을 더한다
      int[][] addDust = new int[r][c];
      for(int i = 0 ; i < r ; i++){
        Arrays.fill(addDust[i], 0);
      }


      for(int i = 0 ; i < r ; i++){
        for(int j = 0 ; j < c ; j++){
          // 자신에서 확산된 먼지들 만큼은 pan에서 뺀다
          List<Node> adjust = findAdjust(i,j,pan);
          int spread = pan[i][j] / 5;
          adjust.forEach(node -> addDust[node.x][node.y] += spread);
          pan[i][j] -= (spread * adjust.size());
        }
      }

      // 다 순회하면 자신 위치에 확산된 먼지를 더한다.
      for(int i = 0 ; i < r ; i++) {
        for (int j = 0; j < c; j++) {
          pan[i][j] += addDust[i][j];
        }
      }

      // 공기청정기 순회를 한다.
      // 위쪽 공기청정기
      if(aircon.get(0).x > 0){
        for(int i = aircon.get(0).x - 2 ; i >= 0 ; i--){
          pan[i+1][0] = pan[i][0];
        }
        for(int i = 0 ; i < c-1 ; i++){
          pan[0][i] = pan[0][i+1];
        }
        for(int i = 0 ; i < aircon.get(0).x ; i++){
          pan[i][c-1] = pan[i+1][c-1];
        }
        for(int i = c-1 ; i > 1 ; i--){
          pan[aircon.get(0).x][i] = pan[aircon.get(0).x][i-1];
        }
        pan[aircon.get(0).x][1] = 0;
      }


      // 아래쪽 공기청정기
      if(r -1 > aircon.get(1).x) {
        for(int i = aircon.get(1).x + 1 ; i < r-1 ; i++){
          pan[i][0] = pan[i+1][0];
        }

        for(int i = 0 ; i < c-1 ; i++){
          pan[r-1][i] = pan[r-1][i+1];
        }

        for(int i = r-1 ; i > aircon.get(1).x ; i--){
          pan[i][c-1] = pan[i-1][c-1];
        }

        for (int i = c - 1; i > 1; i--) {
          pan[aircon.get(1).x][i] = pan[aircon.get(1).x][i - 1];
        }
        pan[aircon.get(1).x][1] = 0;
      }

    }

    for(int i = 0 ; i < r ; i++){
      for(int j = 0 ; j < c ; j++){
        if(pan[i][j] > 0){
          result += pan[i][j];
        }
      }
    }

    return result;
  }

  public static List<Node> findAdjust(int i, int j, int[][] pan){
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    List<Node> adjust = new ArrayList<>();

    for(int k = 0 ;  k < 4; k++){
      int x = i + dx[k];
      int y = j + dy[k];
      if(x >= 0 && x < pan.length && y >= 0 && y < pan[0].length && pan[x][y] != -1){
        adjust.add(new Node(x,y));
      }
    }

    return adjust;
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