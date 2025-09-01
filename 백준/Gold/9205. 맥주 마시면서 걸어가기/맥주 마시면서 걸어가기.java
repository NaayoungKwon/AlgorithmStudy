import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();
    static StringBuilder S;
    static StringBuilder T;

    static List<Set<Integer>> combinationList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       br = new BufferedReader(new InputStreamReader(System.in));

       String[] l = br.readLine().split(" ");
       for(int t = 0 ; t < Integer.parseInt(l[0]) ; t++){
           String[] line = br.readLine().split(" ");
           int n = Integer.parseInt(line[0]);
           line = br.readLine().split(" ");
           int a = Integer.parseInt(line[0]);
           int b = Integer.parseInt(line[1]);
           int[][] store = new int[n][2];
           for(int i = 0 ; i < n ; i++){
               line = br.readLine().split(" ");
               store[i][0] = Integer.parseInt(line[0]);
               store[i][1] = Integer.parseInt(line[1]);
           }
           line = br.readLine().split(" ");
           int c = Integer.parseInt(line[0]);
           int d = Integer.parseInt(line[1]);
           System.out.println(solution42(n,a,b,c,d,store));
           
       }

    }

    public static String solution42(int n, int a, int b, int c, int d, int[][] store) {

        int BEER_POWER = 50 * 20;
        int[][] nodes = new int[n+2][2];
        nodes[0] = new int[]{a,b};
        for(int i = 1 ; i <= n ; i++){
            nodes[i][0] = store[i-1][0];
            nodes[i][1] = store[i-1][1];
        }
        nodes[n+1] = new int[]{c,d};

        List<R> routes = new ArrayList<>();
        for(int i = 0 ; i < nodes.length - 1; i++){
            for(int j = i+1 ; j < nodes.length ; j++){
                int dist = Math.abs(nodes[i][0] - nodes[j][0]) + Math.abs(nodes[i][1] - nodes[j][1]);
                if(dist <= BEER_POWER){
                    routes.add(new R(i,j));
                }
            }
        }
        int[] partent = new int[n+2];
        for(int i = 0 ; i < n+2 ; i++){
            partent[i] = i;
        }
        for(R route : routes){
            if(find(partent, route.s_idx) != find(partent, route.e_idx)){
                union(partent, route.s_idx, route.e_idx);
            }
        }

        if(find(partent,0) == find(partent, n+1)){
            return "happy";
        }

        return "sad";
    }

    public static int find(int[] parent, int a){
        if(parent[a] != a){
            parent[a] = find(parent, parent[a]);
        }
        return parent[a];
    }

    public static void union(int[] parent, int a, int b){
        int pa = find(parent, a);
        int pb = find(parent, b);
        if(pa != pb){
            parent[pb] = pa;
        }
    }

    public static class R {
        int s_idx;
        int e_idx;

        public R(int s_idx, int e_idx) {
            this.s_idx = s_idx;
            this.e_idx = e_idx;
        }
    }
}