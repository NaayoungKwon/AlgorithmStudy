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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] candies = new int[N + 1]; // 1-indexed
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candies[i] = Integer.parseInt(st.nextToken());
        }

        int[] A = new int[M];
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution53(N,M,K, candies, A, B));
    }   

    public static int solution53(int N, int M, int K, int[] candies, int[] A, int[] B){

        int[] parent = new int[N+1];
        for(int i = 1 ; i <= N ; i++){
            parent[i] = i;
        }
        for(int i = 0 ; i < M ; i++){
            int a = A[i];
            int b = B[i];
            int pa = find(parent, a);
            int pb = find(parent, b);
            union(parent, Math.min(pa, pb), Math.max(pa, pb));
        }
        
        Map<Integer, Integer> groupCandy = new HashMap<>();
        Map<Integer, Integer> groupSize = new HashMap<>();
        for(int i = 1; i <= N ; i++){
            int p = find(parent, i);
            groupCandy.put(p, groupCandy.getOrDefault(p, 0) + candies[i]);
            groupSize.put(p, groupSize.getOrDefault(p, 0) + 1);
        }

        int[] dp = new int[K];
        Arrays.fill(dp, 0);
        for (Integer key : groupCandy.keySet()) {
            int gCandy = groupCandy.get(key);
            int gSize = groupSize.get(key);
            if(gSize >= K){
                continue;
            }

            for(int i = K - gSize -1; i >= 1 ; i--){
                if(dp[i] == 0){
                    continue;
                }
                dp[i + gSize] = Math.max(dp[i + gSize], dp[i] + gCandy);
            }
            dp[gSize] = Math.max(dp[gSize], gCandy);
        }

        int answer = 0;
        for(int i = 1 ; i < K ; i++){
            answer = Math.max(answer, dp[i]);
        }
        return answer;
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