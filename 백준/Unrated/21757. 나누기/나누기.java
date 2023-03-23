import java.io.*;
import java.util.*;

public class Main {

    static List<String> answer;
    private static BufferedReader br;
    static int[] arr;


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr= Arrays.stream(br.readLine().split(" ")).mapToInt(j->Integer.parseInt(j)).toArray();
        solution(T);
    }

    static void solution(int n){
        long s = Arrays.stream(arr).sum();
        if(s % 4 > 0 ){
            System.out.println(0);
            return ;
        }
        long target = s/4;
        System.out.println(rec(0,n, target));
    }

    static int rec(int start, int n, long target){
        long thisSum = 0;
        int cnt = 0;
        if(start == n){
            return 1;
        }
        for(int i = start ; i < n ; i++){
            // thisSum에 더해가다가 target을 만나면 다시 recursive 호출
            thisSum += arr[i];
            if(thisSum == target){
                cnt += rec(i+1, n, target);
            }
        }
        return cnt;
    }

}