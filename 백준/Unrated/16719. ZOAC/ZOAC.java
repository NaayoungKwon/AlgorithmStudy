import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();
    static String zoac;
    static boolean[] visited;


    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        zoac = br.readLine();
        visited = new boolean[zoac.length()];
        solution(0,zoac.length()-1);
        System.out.println(sb);
    }

    static void solution(int left, int right) {
        if (left > right) {
            return;
        }
        int min_idx = left;
        for (int i = left; i <= right; i++) {
            if (zoac.charAt(min_idx) > zoac.charAt(i)) {
                min_idx = i;
            }
        }
        visited[min_idx] = true;
        for (int i = 0; i < zoac.length(); i++) {
            if (visited[i]) {
                sb.append(zoac.charAt(i));
            }
        }
        sb.append("\n");
        solution(min_idx + 1, right);
        solution(left, min_idx - 1);

    }
}