
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.management.RuntimeErrorException;

public class Main {

    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();
    static StringBuilder S;
    static StringBuilder T;

    static List<Set<Integer>> combinationList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()); // 세로
        int C = Integer.parseInt(st.nextToken()); // 가로

        int[][] board = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); // 0 or 1
            }
        }
        solution55(R, C, board);
    } 

    public static void solution55(int R, int C, int[][] board){
        // 뭉텅이 단위를 알아낸다

        int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
                // loop를 돈다
        int time = 0;
        int prev = 0;
        while(true){
            Set<P55> group = new HashSet<>();
            boolean[][] visited = new boolean[R][C];
            
            for(int i = 0; i < R; i++){
                for(int j = 0; j < C ; j++){
                    if(board[i][j] == 0 || visited[i][j]){
                        continue;
                    }
                    Queue<P55> queue = new LinkedList<>();
                    queue.add(new P55(i,j));
                    visited[i][j] = true;
                    while(!queue.isEmpty()){
                        P55 now = queue.poll();
                        group.add(now);
                        for(int[] dir : dirs){
                            int nx = now.x + dir[0];
                            int ny = now.y + dir[1];
                            if(nx < 0 || nx >= R || ny < 0 || ny >= C){
                                continue;
                            }
                            if(board[nx][ny] == 0 || visited[nx][ny]){
                                continue;
                            }
                            visited[nx][ny] = true;
                            queue.add(new P55(nx, ny));
                        }
                    }
                }
            }
            


            Set<P55> edges = new HashSet<>();
            Set<P55> airs = new HashSet<>();

            visited = new boolean[R][C];

            Queue<P55> queue = new LinkedList<>();
            queue.add(new P55(0,0));
            visited[0][0] = true;
            while(!queue.isEmpty()){
                P55 now = queue.poll();
                airs.add(now);
                for(int[] dir : dirs){
                    int nx = now.x + dir[0];
                    int ny = now.y + dir[1];
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C){
                        continue;
                    }
                    if(board[nx][ny] == 1 || visited[nx][ny]){
                        continue;
                    }
                    visited[nx][ny] = true;
                    queue.add(new P55(nx, ny));
                }
            }
            
            for(P55 air : airs){
                for(int[] dir : dirs){
                    int nx = air.x + dir[0];
                    int ny = air.y + dir[1];
                    if(nx < 0 || nx >= R || ny < 0 || ny >= C){
                        continue;
                    }
                    if(board[nx][ny] == 0){
                        continue;
                    }
                    edges.add(new P55(nx, ny));
                }
            }

            
            if(edges.size() == 0){
                break;
            }
            time += 1;
            prev = edges.size();
            for(P55 e : edges){
                board[e.x][e.y] = 0;
            }
            // System.out.println(edges.size() + " " + time);
        }
        System.out.println(time);
        System.out.println(prev);
    }

    public static class P55{
        int x;
        int y;

        public P55(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if(!(o instanceof P55)) return false;
            P55 other = (P55)o;
            return this.x == other.x && this.y == other.y;
        }

        @Override
        public int hashCode(){
            return x * 10000 + y;
        }
    }
}