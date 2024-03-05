import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Template {
    static FastReader scan = new FastReader();
    //정답은 sb에 append 를 사용하여 출력
    //만약 개행까지 출력하고 싶으면 append('\n')을 추가
    static StringBuilder sb = new StringBuilder();
    static List<String> answer;
    private static BufferedReader br;

    static int pointer = -1;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            answer = new ArrayList<>();
            pointer = -1;
            int n = Integer.parseInt(br.readLine());
            int[] pre = Arrays.stream(br.readLine().split(" ")).mapToInt(j->Integer.parseInt(j)).toArray();
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(j->Integer.parseInt(j)).toArray();
            solution(n, pre, in);
        }
//        T = new StringBuilder(br.readLine());
//        solution(4, new int[]{3,2,1,4}, new int[]{2,3,4,1});
//        solution(8, new int[]{3, 6 ,5 ,4 ,8,7, 1 ,2}, new int[]{5, 6, 8, 4, 3 ,1 ,2 ,7});
//        System.out.println(sb);
    }

    static void solution(int n, int[] pre, int[] in){


        // pre[i]의 값을 in에 어딨는지 찾는다 = j  val = pre[i]
        // (0,j-1) 범위에서 찾으세요 다음건 i+1입니다 left = pre[i+1]
        // (j+1, n-1)
        Node tree = find(pre, in, 0, n-1);
        postOrder(tree);
        System.out.println(String.join(" ",  answer));
    }

    public static Node find(int[] pre, int[] in, int start, int end){
        if(start > end ){
            return null;
        } else if(start == end){
            pointer += 1;
            return new Node(in[end] , null, null);
        }
        pointer += 1;
        int val = pre[pointer], i = start;
        for( ; i <= end ; i++){
            if(in[i] == val){
                break;
            }
        }

        Node left = find(pre, in,  start, i-1);
        Node right = find(pre, in, i+1 ,end);
        return new Node(val, left, right);
    }

    public static void postOrder(Node n){
        if(n == null){
            return ;
        }
        postOrder(n.left);
        postOrder(n.right);
//        sb.append(n.val);
        answer.add(String.valueOf(n.val));
    }

    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static void input(){
        StringBuilder s = new StringBuilder();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}