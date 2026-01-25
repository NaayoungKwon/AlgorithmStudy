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

        int N = Integer.parseInt(br.readLine().trim());

        int[] U = new int[N - 1];
        int[] V = new int[N - 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            U[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution57(N,U,V));
    } 

    public static int solution57(int n, int[] u, int[] v){

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] level = new int[n+1];
        Arrays.fill(level, 0);
        for(int i = 0 ; i < u.length ; i++){
            graph.putIfAbsent(u[i], new ArrayList<>());
            graph.putIfAbsent(v[i], new ArrayList<>());
            graph.get(u[i]).add(v[i]);
            graph.get(v[i]).add(u[i]);
            level[u[i]]++;
            level[v[i]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int last = 0;
        for(int i = 1 ; i <= n ; i++){
            if(level[i] == 1){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int now = queue.poll();
            last = now;
            level[now]--;
            for(Integer next : graph.get(now)){
                level[next]--;
                if(level[next] == 1){
                    queue.add(next);
                }
            }
        }
        

        boolean[] visited = new boolean[n+1];
        Arrays.fill(visited, false);
        Queue<P57> que2 = new LinkedList<>();
        que2.add(new P57(last, 0));
        visited[last] = true;

        int maxLen = 0;
        while(!que2.isEmpty()){
            P57 now = que2.poll();

            for(Integer next : graph.get(now.node)){
                if(visited[next]){
                    continue;
                }

                visited[next] = true;
                que2.add(new P57(next, now.len +1));
                maxLen = Math.max(maxLen, now.len +1);
            }
        }

        
        return maxLen;
    }
    
    public static class P57{
        int node;
        int len;

        public P57(int node, int len) {
            this.node = node;
            this.len = len;
        }
    }
}