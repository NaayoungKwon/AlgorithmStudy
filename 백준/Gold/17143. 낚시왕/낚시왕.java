import java.io.*;
import java.util.*;



public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    String[] split = br.readLine().split(" ");
    int r = Integer.parseInt(split[0]), c = Integer.parseInt(split[1]), m = Integer.parseInt(split[2]);
    Shark[][] arr = new Shark[r+1][c+1];

    for(int i = 0 ; i < m ; i++){
      String[] s = br.readLine().split(" ");
      Shark shark = new Shark(Integer.parseInt(s[0]), Integer.parseInt(s[1]),
          Integer.parseInt(s[2]), Integer.parseInt(s[3]), Integer.parseInt(s[4]));
      arr[shark.x][shark.y] = shark;
    }

    solution(r, c, m, arr);
  }



  public static void solution(int r, int c, int m, Shark[][] arr) {
    int result = 0;
    for(int j = 1 ; j <= c ; j++) {
      // 아저씨 움직여
      for (int i = 1; i <= r; i++) {
        // 가까운 상어를 찾아서 잡아먹는다.
        if(arr[i][j] != null){
          result += arr[i][j].size;
          arr[i][j] = null;
          break;
        }
      }

      // 상어 하나 씩 움직인다
      // 판을 새로 짜
      Shark[][] new_arr = new Shark[r+1][c+1];
      for (int i = 1; i <= r; i++) {
        for (int k = 1; k <= c; k++) {
          if (arr[i][k] == null) {
            continue;
          }

          Shark shark = arr[i][k];
          shark.move(r, c);
          if (new_arr[shark.x][shark.y] == null) {
            new_arr[shark.x][shark.y] = shark;
          } else {     // 움직이면서 arr에 업데이트 하려는데 이미 있으면 잡아먹을 놈을 만든다.
            if (new_arr[shark.x][shark.y].size < shark.size) {
              new_arr[shark.x][shark.y] = shark;
            }
          }
        }
      }
      arr = new_arr;
    }
    System.out.println(result);
  }

  public static class Shark{
    int x;
    int y;
    int speed;
    int size;
    int d;
    int[][] dirs = {{}, {-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public Shark(int x, int y, int  speed, int d, int size){
      this.x = x;
      this.y = y;
      this.speed = speed;
      this.size = size;
      this.d = d;
    }

    public void move(int r, int c){
      int mx = this.x  + this.speed * this.dirs[this.d][0];
      while(mx <= 0 || mx > r){
        changeDir();
        if(mx <= 0){
          mx = Math.abs(mx) + 2;
        } else {
          mx = 2 * r - mx;
        }
      }
      this.x = mx;

      int my = this.y + this.speed * this.dirs[this.d][1];
      while(my <= 0 || my > c){
        changeDir();
        if(my <= 0){
          my = Math.abs(my)+2;
        } else {
          my = 2 * c - my;
        }
      }
      this.y = my;
    }

    public void changeDir(){
      if (this.d == 1) {
        this.d = 2;
      } else if (this.d == 2) {
        this.d = 1;
      } else if (this.d == 3) {
        this.d = 4;
      } else if (this.d == 4) {
        this.d = 3;
      }
    }

  }
}