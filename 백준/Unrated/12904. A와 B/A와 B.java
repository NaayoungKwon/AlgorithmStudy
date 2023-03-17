import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();
    static StringBuilder S;
    static StringBuilder T;


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        S = new StringBuilder(br.readLine());
        T = new StringBuilder(br.readLine());
        if(S.length() > T.length()){
            System.out.println(0);
            return ;
        }
        char last = S.charAt(S.length()-1);
        while(S.length() <= T.length()){
//            System.out.println(T);
            if(S.length() == T.length()){
                if(S.toString().equals(T.toString())){
                    System.out.println(1);
                } else{
                    System.out.println(0);
                }
                return ;
            }
            // 끝이 둘다 A면
            Integer lastIdx = T.length()-1;
            if(T.charAt(lastIdx) == 'A'){
                T.deleteCharAt(lastIdx);
            } else if (T.charAt(lastIdx) == 'B'){
                T.deleteCharAt(lastIdx);
                T.reverse();
            }
        }
        System.out.println(0);

    }

}