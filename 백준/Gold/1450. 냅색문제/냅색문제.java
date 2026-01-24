
import java.io.*;
import java.util.*;
public class Main {

    private static BufferedReader br;


    static List<Set<Integer>> combinationList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

    //    int n = Integer.parseInt(br.readLine().split(" ")[0]);
    //    String[] w = br.readLine().split(" ");
    //    int m = Integer.parseInt(br.readLine().split(" ")[0]);
    //    Map<Integer, List<Integer>> map_ = new HashMap<>();
    //    Map<Integer, Integer> parent = new HashMap<>();
    //    for(int t = 0 ; t < m; t++){
    //        String[] q  = br.readLine().split(" ");
    //        int a = Integer.parseInt(q[0]);
    //        int b = Integer.parseInt(q[1]);
    //        map_.getOrDefault(a, new ArrayList<>()).add(b);
    //        parent.put(b, a);
    //    }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long[] w = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            w[i] = Long.parseLong(st.nextToken());
        }
        System.out.println(solution47(N, C, w));

    }

    public static long solution47(int n, long c, long[] arr){
        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();
        int mid = ((n-1) / 2);
        half(0, mid, c, left, 0, arr);
        half(mid+1 , n-1,c, right, 0, arr);
        Collections.sort(left);
        Collections.sort(right);
        int answer = 0;
        // System.out.println(left.toString());

        for (Long e : left) {
            long more = c - e;
            int index = upperBound(right, more);
            answer += (index);
        }

        return answer;
    }

    public static void half(int s, int e, long c, List<Long> answer, long sum, long[] arr){
        if (sum > c){
            return ;
        }
        
        if(s > e){
            answer.add(sum);
            return ;
        } 
    
        half(s+1, e, c, answer, sum+arr[s], arr);
        half(s+1, e, c, answer, sum, arr);
    }

    public static int upperBound(List<Long> list, long key) {
        int l = 0, r = list.size(); // [l, r)
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (list.get(mid) <= key) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}