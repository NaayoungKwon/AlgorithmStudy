
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

        int[] result = new int[3];
        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine().trim());

            int[] value = new int[N];
            int[] count = new int[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                value[i] = Integer.parseInt(st.nextToken());
                count[i] = Integer.parseInt(st.nextToken());
            }

            // t번째 케이스 입력 완료
            // N: 동전 종류 수
            // value[i]: i번째 동전 금액
            // count[i]: i번째 동전 개수
            result[t] = solution56(N, value, count);
        }
        for (int res : result) {
            System.out.println(res);
        }
    } 

    public static int solution56(int n, int[] value, int[] count){
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            sum += (value[i] * count[i]);
        }

        int half = sum / 2;
        if(sum % 2 != 0){
            return 0;
        }

        boolean[] dp = new boolean[half +1];
        for(int i = 0; i < n; i++){
            for(int j = half; j >= 0 ; j--){
                for(int c = 1; c <= count[i]; c++){
                    int money = value[i] * c;
                    if(j < money){
                        break;
                    }
                    dp[j] = dp[j] || dp[j-money];
                }
            }
            for(int j = 0 ; j < count[i]; j++){
                int money = value[i] * (j+1);
                if(half < money){
                    break;
                }
                dp[money] = true;
            }
        }
        return dp[half] ? 1 : 0;
    }

}