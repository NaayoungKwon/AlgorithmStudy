
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Queue;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;




  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");
    int m = Integer.parseInt(split[0]);
    int n = Integer.parseInt(split[1]);
    int h = Integer.parseInt(split[2]);

    int[][][] pan = new int[h][n][m];
    for(int k = 0 ; k < h ; k++ ) {
      for (int i = 0; i < n; i++) {
        String[] split1 = br.readLine().split(" ");
        for (int j = 0; j < m; j++) {
          pan[k][i][j] = Integer.parseInt(split1[j]);
        }
      }
    }

    System.out.println(solution(n, m, h, pan));


  }



  public static int solution(int n, int m, int h,  int[][][] pan) {
    int unrottenTomato = 0;
    Queue<Tomato> rottenTomato = new ArrayDeque<>();
    for(int k = 0 ; k < h ; k++ ) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if(pan[k][i][j] == 1){
            rottenTomato.add(new Tomato(i,j,k,0));
          } else if (pan[k][i][j] == 0){
            unrottenTomato++;
          }
        }
      }
    }

    if(rottenTomato.isEmpty()){
      return -1;
    } else if (rottenTomato.size() == n*m*h){
      return 0;
    }

    int[] dx = {0,0,1,-1,0,0};
    int[] dy = {1,-1,0,0,0,0};
    int[] dh = {0,0,0,0,1,-1};

    int lastDay = 0;
    while(!rottenTomato.isEmpty()){
      Tomato rotten = rottenTomato.poll();
      lastDay = Math.max(lastDay, rotten.day);
      for(int i = 0 ; i < 6 ; i++){
        int nx = rotten.x + dx[i];
        int ny = rotten.y + dy[i];
        int nh = rotten.z + dh[i];
        if(nx < 0 || nx >= n || ny < 0 || ny >= m || nh < 0 || nh >= h || pan[nh][nx][ny] != 0){
          continue;
        }
        pan[nh][nx][ny] = 1;
        unrottenTomato --;
        rottenTomato.add(new Tomato(nx,ny,nh,rotten.day+1));
      }
    }
    return unrottenTomato > 0 ? -1 : lastDay;
  }


  public static class Tomato{
    int x,y,z,day;

    public Tomato(int x, int y, int z, int day){
      this.x = x;
      this.y = y;
      this.z = z;
      this.day = day;
    }

  }


}