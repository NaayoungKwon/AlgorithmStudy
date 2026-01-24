
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

        int n = Integer.parseInt(br.readLine().split(" ")[0]);
        solution50(n);

    }

    public static void solution50(int n){
        if(n == 1){
            System.out.println(2);
            System.out.println(3);
            System.out.println(5);
            System.out.println(7);
            return ;
        }

        List<Integer> primes = new ArrayList<>();
        dfs50(n, 2, primes);
        dfs50(n, 3, primes);
        dfs50(n, 5, primes);
        dfs50(n, 7, primes);
        for (Integer p : primes) {
            System.out.println(p);
        }
    }

    public static void dfs50(int n, int num, List<Integer> answer){
        if(isPrime(num) == false){
            return ;
        }
        if (String.valueOf(num).length() == n){
            answer.add(num);
            return ;
        }

        List<Integer> nexts = Arrays.asList(1,3,7,9);
        for(int i : nexts){
            int nextNum = num * 10 + i;
            dfs50(n, nextNum, answer);
        }
    }

    public static boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i = 2 ; i <= Math.sqrt(num) ; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}