
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
        String S = br.readLine().trim();
        String P = br.readLine().trim();
        System.out.println(solution60(S, P));
    }

    public static int solution60(String s, String p){

        int p_start = 0;
        int index = 1;
        int p_len = p.length();

        int answer = 0;
        while(index <= p_len){
            if(s.contains(p.substring(p_start, index))){
                index++;
                continue;
            }
            answer += 1;
            p_start = index -1;
            index = p_start + 1;
        }
        return answer+1;
    }
}