import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br;
    private static StringBuilder sb = new StringBuilder();
    static StringBuilder S;
    static StringBuilder T;

    static List<Set<Integer>> combinationList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
       br = new BufferedReader(new InputStreamReader(System.in));

       int n = Integer.parseInt(br.readLine().split(" ")[0]);
       String[] w = br.readLine().split(" ");
       int m = Integer.parseInt(br.readLine().split(" ")[0]);
       Map<Integer, List<Integer>> map_ = new HashMap<>();
       Map<Integer, Integer> parent = new HashMap<>();
       for(int t = 0 ; t < m; t++){
           String[] q  = br.readLine().split(" ");
           int a = Integer.parseInt(q[0]);
           int b = Integer.parseInt(q[1]);
           map_.getOrDefault(a, new ArrayList<>()).add(b);
           parent.put(b, a);
       }
       System.out.println(solution43(n, Integer.valueOf(w[0]), Integer.valueOf(w[1]), parent));

    }

    public static Integer solution43(int n, int a, int b, Map<Integer, Integer> parentMap){
        
        // int[] aPar : a의 조상들
        // int[] bPar : b의 조상들    
        List<Integer> aParents = new ArrayList<>();
        List<Integer> bParents = new ArrayList<>();
        
        int ap = a;
        aParents.add(a);
        while(parentMap.containsKey(ap)){
            aParents.add(parentMap.get(ap));
            ap = parentMap.get(ap);
        }

        int bp = b;
        bParents.add(b);
        while(parentMap.containsKey(bp)){
            bParents.add(parentMap.get(bp));
            bp = parentMap.get(bp);
        }

        for(int i = 0 ; i < aParents.size() ; i++){
            for(int j = 0 ; j < bParents.size() ; j++){
                if(aParents.get(i).equals(bParents.get(j))){
                    return i+j;
                }
            }
        }

        return -1;
    }
}