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


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] w = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution48(N, S, w));

    }


    public static long solution48(int n, int s, int[] arr){
        List<Integer> left= new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int mid = (n-1)/2;

        combsum(0, mid, 0, left, arr);
        combsum(mid+1, n-1, 0, right ,arr);
        Collections.sort(left);
        Collections.sort(right);
        long answer = 0;

        for (Integer e : left) {
            int d = s - e;
            int d_count = upperBound(right, d) - lowerBound(right, d);
            answer += d_count;
        }

        if(s == 0){
            answer -= 1;
        }
        return answer;
    }

    public static void combsum(int s, int e, int sum, List<Integer> answer, int[] arr){
        if(s > e){
            answer.add(sum);
            return ;
        }

        
        combsum(s+1, e, sum+arr[s], answer, arr);
        combsum(s+1, e, sum, answer, arr);
    }
    
        public static int upperBound(List<Integer> list, long key) {
        int l = 0, r = list.size(); // [l, r)
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) <= key) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public static int lowerBound(List<Integer> list, long key) {
        int l = 0, r = list.size(); // [l, r)
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) < key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}