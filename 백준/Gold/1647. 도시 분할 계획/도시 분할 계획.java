
import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.nio.file.Path;
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

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        List<P59> paths = new ArrayList<>();
        for (int i = 0 ; i < m ; i++){
            String[] split1 = br.readLine().split(" ");
            int a = Integer.parseInt(split1[0]);
            int b = Integer.parseInt(split1[1]);
            paths.add(new P59(Math.min(a,b), Math.max(a,b), Integer.parseInt(split1[2])));
        }
        System.out.println(solution59(n,m, paths));
    }

    public static int solution59(int n, int m, List<P59> paths){
        PriorityQueue<P59> pq = new PriorityQueue<>(P59::compareTo);
        for(P59 p : paths){
            pq.add(p);
        }

        int[] parent = new int[n+1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }

        int totalWeight = 0;
        int maxWeight = 0;
        while(!pq.isEmpty()){
            P59 now = pq.poll();
            int fa = find(parent, now.start);
            int fb = find(parent, now.end);
            if(fa != fb){
                union(parent, fa, fb);
                totalWeight += now.weight;
                maxWeight = Math.max(maxWeight, now.weight);
            }
        }

        return totalWeight - maxWeight;
    }

    public static class P59{
        int start;
        int end;
        int weight;

        public P59(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(P59 other){
            return Integer.compare(this.weight, other.weight);
        }
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
}