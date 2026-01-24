import java.io.*;
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

        int C = Integer.parseInt(st.nextToken()); // 목표 고객 수
        int N = Integer.parseInt(st.nextToken()); // 도시 개수

        int[] cost = new int[N];
        int[] customer = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution51(C, N, cost, customer));
    }   

    public static int solution51(int c, int n, int[] cost, int[] customer){
        int[] dp = new int[c+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n ; i++){
            // int next_customer = Math.min(c, customer[i]);
            // dp[next_customer] = Math.min(dp[next_customer],cost[i]);
            int j = 0;
            while(true){
                int next = j + customer[i];
                if(j > c){
                    break;
                }
                if(dp[j] == Integer.MAX_VALUE){
                    j++;
                    continue;
                }
                dp[Math.min(next,c)] = Math.min(dp[Math.min(next, c)], dp[j] + cost[i]);
                j++;
            }
            
        }
        return dp[c];
    }
}