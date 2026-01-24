
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
        int K = Integer.parseInt(st.nextToken());

        int[] M = new int[N];
        int[] V = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] C = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            C[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution54(N,K, M,V, C));
    } 

    public static long solution54(int N, int K, int[] M, int[] V, int[] C){
        PriorityQueue<Dia> diaPQ = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        PriorityQueue<Dia> bagQueue = new PriorityQueue<>((a,b) -> b.money - a.money);
        
        for(int i = 0 ; i < N ; i++){
            diaPQ.add(new Dia(M[i], V[i]));
        }
        Arrays.sort(C);
        long answer = 0;
        for(int i = 0 ; i < K ; i++){
            int capacity = C[i];
            while(!diaPQ.isEmpty() && diaPQ.peek().weight <= capacity){
                Dia d = diaPQ.poll();
                bagQueue.add(d);
            }
            Dia d = bagQueue.isEmpty() ? null : bagQueue.poll();
            if(d == null){
                continue;
            }
            answer += d.money;
        }
        return answer;
    }

    public static class Dia{
        int weight;
        int money;

        public Dia(int weight, int money) {
            this.weight = weight;
            this.money = money;
        }
    }
}