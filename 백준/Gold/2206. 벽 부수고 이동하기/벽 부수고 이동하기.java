import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  private static BufferedReader br;
  
      public static void main(String[] args) throws IOException {
       br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();   // 예: "0100"
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0'; // '0'/'1' -> 0/1
            }
        }
        
        System.out.println(solution44(N, M, map));


    }

    public static int solution44(int n , int m, int[][] map){
        Queue<P> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[n][m][2];
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        if(n ==1 && m ==1){
            return 1;
        }
        if(map[0][0] == 1){
            visited[0][0][1] = true;
            queue.add(new P(0,0,true,1));
        } else {
            visited[0][0][0] = true;
            queue.add(new P(0,0,false,1));
        }

        while (!queue.isEmpty()){
            P now = queue.poll();

            for(int[] dir : dirs){

                P next = new P(now.x + dir[0], now.y + dir[1], now.broken, now.len +1);
                if(!next.isInRange(n, m)){
                    continue;
                }
                if(next.x == n-1 && next.y == m-1){
                    return next.len;
                }
                if(visited[next.x][next.y][next.broken ? 1 : 0] == false && map[next.x][next.y] == 0){
                    visited[next.x][next.y][next.broken ? 1 : 0] = true;
                    queue.add(next);
                }
                

                if(next.broken){
                    continue;
                }
                P next2 = new P(now.x + dir[0], now.y + dir[1], true, now.len +1);
                if(visited[next2.x][next2.y][1] == false && map[next2.x][next2.y] == 1){
                    visited[next2.x][next2.y][1] = true;
                    queue.add(next2);
                }
                

            }

        }


        return -1;
    }

    public static class P {
        int x;
        int y;
        boolean broken;
        int len;

        public P(int x, int y, boolean broken, int len) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.len = len;
        }

        public boolean isInRange(int n, int m){
            return x >= 0 && x < n && y >= 0 && y < m;
        }
    }



}