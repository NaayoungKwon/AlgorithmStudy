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

    //    int n = Integer.parseInt(br.readLine().split(" ")[0]);
    //    String[] w = br.readLine().split(" ");
    //    int m = Integer.parseInt(br.readLine().split(" ")[0]);
    //    Map<Integer, List<Integer>> map_ = new HashMap<>();
    //    Map<Integer, Integer> parent = new HashMap<>();
    //    for(int t = 0 ; t < m; t++){
    //        String[] q  = br.readLine().split(" ");
    //        int a = Integer.parseInt(q[0]);
    //        int b = Integer.parseInt(q[1]);
    //        map_.getOrDefault(a, new ArrayList<>()).add(b);
    //        parent.put(b, a);
    //    }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[] chars = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            chars[i] = st.nextToken().charAt(0);
        }
        solution49(L, C, chars);

    }

    public static void solution49(int l, int c, char[] arr){
        List<String> answers = new ArrayList<>();
        dfs49(0, l, c, answers, new char[l], arr, -1);
        Collections.sort(answers);
        for (String answer : answers) {
            System.out.println(answer);
        }

    }

    public static void dfs49(int i, int l, int c, List<String> answers, char[] sum, char[] arr, int lastIdx){
        if(sum != null &&  lastIdx +1 == l){
            String ss = new String(sum);
            char[] chars = ss.toCharArray();
            Arrays.sort(chars);
            String sort = String.valueOf(chars);
            int a = 0, b= 0;
            for(char ch : chars){
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    a++;
                } else {
                    b++;
                }
            }
            if(a >= 1 && b >= 2){
                answers.add(sort);
            }
            return ;
        }

        if(i >= c ){
            return ;
        }

        sum[lastIdx +1] = arr[i];
        dfs49(i+1, l, c, answers, sum, arr, lastIdx +1);
        dfs49(i+1, l, c, answers, sum, arr , lastIdx);
    }
}