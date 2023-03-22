import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

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

}