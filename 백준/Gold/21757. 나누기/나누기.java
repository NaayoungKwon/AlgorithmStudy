import java.io.*;
import java.util.*;

public class Main {
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
        long[] sList = new long[n];
        sList[0] = arr[0];
        for(int i = 0 ; i < n-1 ; i++){
            sList[i+1] = sList[i] + arr[i+1];
        }
        int[] cnt = new int[4];
        for(int i = 0 ; i < n ; i++){
            if(sList[i] == (target * 3) ){
                cnt[3] += cnt[2];
            } else if(sList[i] == (target *2)){
                cnt[2] += cnt[1];
            } else if(sList[i] == target ){
                cnt[1] += 1;
            }
        }
        System.out.println(cnt[3]);
    }

}