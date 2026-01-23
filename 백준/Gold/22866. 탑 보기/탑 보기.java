import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

  private static BufferedReader br;


    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] height = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        
        solution45(N, height);


    }

    public static void solution45(int n, int[] height){
        int[] left = new int[n];
        int[] right = new int[n];
        int[] d = new int[n];
        // d 는 최댓값을 넣어두고 최솟값을 구할것
        Arrays.fill(d, Integer.MAX_VALUE);
        Stack<S45> stack = new Stack<>();

        for(int i = 0 ; i < n ; i++){
            while(!stack.isEmpty() && stack.peek().height <= height[i]){    
                S45 top = stack.pop();
                int left_size = stack.size();
                left[top.index] = left_size;
                int bottom = !stack.isEmpty() ? stack.peek().index : Integer.MAX_VALUE;
                if(Math.abs(top.index - d[top.index]) > Math.abs(top.index - bottom)){
                        d[top.index] = bottom;
                } else if (Math.abs(top.index - d[top.index]) == Math.abs(top.index - bottom) && d[top.index] > bottom){
                    d[top.index] = bottom;
                }
            }
            stack.push(new S45(height[i], i));
        }
        while(!stack.isEmpty()){
            S45 top = stack.pop();
            int left_size = stack.size();
            left[top.index] = left_size;
            int bottom = !stack.isEmpty() ? stack.peek().index : Integer.MAX_VALUE;
            if(Math.abs(top.index - d[top.index]) > Math.abs(top.index - bottom)){
                    d[top.index] = bottom;
            } else if (Math.abs(top.index - d[top.index]) == Math.abs(top.index - bottom) && d[top.index] > bottom){
                d[top.index] = bottom;
            }
        }

        stack = new Stack<>();
        for(int i = n-1 ; i >= 0 ; i--){
            while(!stack.isEmpty() && stack.peek().height <= height[i]){    
                S45 top = stack.pop();
                int left_size = stack.size();
                right[top.index] = left_size;

                int bottom = !stack.isEmpty() ? stack.peek().index : Integer.MAX_VALUE;
                if(Math.abs(top.index - d[top.index]) > Math.abs(top.index - bottom)){
                    d[top.index] = bottom;
                } else if (Math.abs(top.index - d[top.index]) == Math.abs(top.index - bottom) && d[top.index] > bottom){
                    d[top.index] = bottom;
                }
            }
            stack.push(new S45(height[i], i));
        }
        while(!stack.isEmpty()){
            S45 top = stack.pop();
            int left_size = stack.size();
            right[top.index] = left_size;

            int bottom = !stack.isEmpty() ? stack.peek().index : Integer.MAX_VALUE;
            if(Math.abs(top.index - d[top.index]) > Math.abs(top.index - bottom)){
                    d[top.index] = bottom;
            } else if (Math.abs(top.index - d[top.index]) == Math.abs(top.index - bottom) && d[top.index] > bottom){
                d[top.index] = bottom;
            }
        }
        
        for(int i = 0 ; i < n ; i++){
            int s = left[i] + right[i];
            if(s == 0){
                System.out.println("0");
            } else {
                System.out.println(s + " " + (d[i]+1));
            }
        }

    }

    public static class S45{
        int height;
        int index;

        public S45(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }

}