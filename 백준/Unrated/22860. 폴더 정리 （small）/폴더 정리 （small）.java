import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br;

    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        HashMap<String, ArrayList<String>> folders = new HashMap<>();
        HashSet<String> files = new HashSet<String>();
        for(int i = 0 ; i < Arrays.stream(nm).sum() ; i++){
            String[] line = br.readLine().split(" ");
            ArrayList<String> ori = folders.getOrDefault(line[0], new ArrayList<>());
                ori.add(line[1]);
                folders.put(line[0], ori);
            if(line[2].equals("0")){
                files.add(line[1]);
            }
        }
        int q = Integer.parseInt(br.readLine());
        ArrayList<String> queries = new ArrayList<>();
        for(int i = 0 ; i < q ; i++){
            String query = br.readLine();
            queries.add(query);
        }
        solution(nm[0], nm[1], folders, files, queries);
    }

    static void solution(int n, int m, HashMap<String, ArrayList<String>> folders, HashSet<String> files, ArrayList<String> queries){
        for(int i = 0 ; i < queries.size() ; i++){
            String[] path = queries.get(i).split("/");
            HashSet<String> fSet = new HashSet<>();
            int fileCnt = 0;
            String keyFolder = path[path.length - 1];
            Queue<String> que = new LinkedList<>();
            if(folders.containsKey(keyFolder)){
                que.addAll(folders.get(keyFolder));
            }
            while(que.isEmpty() == false){
                String e = que.poll();
                if(files.contains(e)){
                    // is file
                    fileCnt += 1;
                    fSet.add(e);
                } else if(folders.containsKey(e)){
                    que.addAll(folders.get(e));
                }
            }
            System.out.println(fSet.size() + " " + fileCnt);
        }
    }

}