import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  private static BufferedReader br;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        long[] A = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(solution46(N, A));

    }

    public static int solution46(int n, long[] arr){
        int answer = 0;
        // sort arr
        Arrays.sort(arr);
        for(int i = 0 ; i < n ; i++){
            long target = arr[i];
            int left = 0;
            int right = n-1;
            while(left < right){
                long sum = arr[left] + arr[right];
                if(sum == target){
                    if(left == i){
                        left++;
                    } else if(right == i){
                        right--;
                    } else{
                        answer++;   
                        break;
                    }
                } else if (sum > target){
                    right--;
                } else {
                    left++;
                }
            }
        }

        return answer;
    }


}