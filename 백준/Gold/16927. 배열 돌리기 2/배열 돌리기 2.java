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
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
    int r = Integer.parseInt(split[2]);

    int[][] pan = new int[n][m];
    for (int i = 0 ; i < n ; i++){
      String[] split1 = br.readLine().split(" ");
      for(int j = 0 ; j < m ; j++){
        pan[i][j] = Integer.parseInt(split1[j]);
      }
    }

    solution(n, m, r, pan);

  }



  public static void solution(int n, int m, int r,  int[][] pan) {
    List<Node> starts = new ArrayList<>();
    for(int i = 0 ; i < Math.min(n,m)/2 ; i++){
      starts.add(new Node(i,i));
    }

    starts.forEach(start -> {
      int thisR = r % modValue(n - (start.x)*2 , m - (start.y)*2);
      Deque<Integer> que = new ArrayDeque<>();
      for(int i = start.x ; i < n-start.x-1 ; i++){
        que.add(pan[i][start.y]);
      }
      for(int j = start.y ; j < m-start.y-1 ; j++){
        que.add(pan[n-start.x-1][j]);
      }
      for(int i = n-start.x-1 ; i > start.x ; i--){
        que.add(pan[i][m-start.y-1]);
      }
      for(int j = m-start.y-1 ; j > start.y ; j--){
        que.add(pan[start.x][j]);
      }

      for(int i = 0 ; i < thisR ; i++){
        que.offerFirst(que.pollLast());
      }

      for(int i = start.x ; i < n-start.x-1 ; i++){
        pan[i][start.y] = que.poll();
      }
      for(int j = start.y ; j < m-start.y-1 ; j++){
        pan[n-start.x-1][j] = que.poll();
      }
      for(int i = n-start.x-1 ; i > start.x ; i--){
        pan[i][m-start.y-1] = que.poll();
      }
      for(int j = m-start.y-1 ; j > start.y ; j--){
        pan[start.x][j] = que.poll();
      }

    });

    StringBuilder sb = new StringBuilder();
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < m ; j++){
        sb.append(pan[i][j]);
        if(j != m-1) {
          sb.append(" ");
        }
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  public static int modValue(int a, int b){
    return (2*a + 2*b -4);
  }


  public static class Node{
    int x;
    int y;

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }

    public int getX(){
      return this.x;
    }


  }


}