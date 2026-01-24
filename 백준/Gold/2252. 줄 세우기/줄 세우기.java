
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

        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 비교 횟수

        int[] nodes = new int[N+1];
        Arrays.fill(nodes, 0);
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[b]++;
            List<Integer> list = graph.getOrDefault(a, new ArrayList<>());
            list.add(b);
            graph.put(a, list);
        }
        solution52(N, M, nodes, graph);
    }   

    public static void solution52(int N, int M, int[] nodes, Map<Integer, List<Integer>> graph){
        Queue<Integer> queue = new LinkedList<>();
        List<String> answer = new ArrayList<>();
        boolean[] visit = new boolean[N+1];
        Arrays.fill(visit, false);
        while(true){
            boolean visited = false;
            for(int i = 1 ; i <= N ; i++){
                if(nodes[i] == 0 && !visit[i]){
                    queue.add(i);
                    visited = true;
                    visit[i] = true;
                }
            }
            if(!visited){
                break;
            }

            while(!queue.isEmpty()){
                int now = queue.poll();
                answer.add(String.valueOf(now));
                graph.getOrDefault(now, Collections.emptyList()).forEach(n -> {
                    nodes[n]--;
                });
            }
        }   
        System.out.println(String.join(" ", answer));

    }
}