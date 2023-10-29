
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.swing.text.DateFormatter;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");
    int n = Integer.parseInt(split[0]);
    int m = Integer.parseInt(split[1]);

    List<Path> paths = new ArrayList<>();
    for (int i = 0 ; i < m ; i++){
      String[] split1 = br.readLine().split(" ");
      int a = Integer.parseInt(split1[0]);
      int b = Integer.parseInt(split1[1]);
      paths.add(new Path(Math.min(a,b), Math.max(a,b), Integer.parseInt(split1[2])));
    }

    System.out.println(solution(n, m, paths));

  }



  public static int solution(int n, int m, List< Path> paths) {
    PriorityQueue<Path> pq = new PriorityQueue<>();
    pq.addAll(paths);
    List<Integer> count = new ArrayList<>();
    int[] parent = new int[n+1];
    for(int i = 0 ; i <= n ; i++){
      parent[i] = i;
    }


    while(!pq.isEmpty()){
      Path path = pq.poll();
      if(find(path.start, parent) != find(path.end, parent)){
        unionFind(path.start, path.end, parent);
        count.add(path.len);
      }
    }

    int sum = 0;
    for(int i = 0 ; i < count.size() - 1 ; i++){
      sum += count.get(i);
    }
    return sum;
  }

  public static void  unionFind(int start , int end, int[] parent){

    int sParent = find(start, parent);
    int eParent = find(end, parent);
    if( sParent != eParent ){
      parent[Math.max(sParent, eParent)] = Math.min(sParent, eParent);
    }

  }

  public static int find(int e , int[] parent){
    if(parent[e] != e){
      parent[e] = find(parent[e], parent);
    }
    return parent[e];
  }

  public static class Path implements Comparable<Path>{
    int start;
    int end;
    int len;

    public Path( int start, int end, int len){
      this.len = len;
      this.start = start;
      this.end = end;
    }

    @Override
    public int compareTo(Path p){
      if(this.len < p.len){
        return -1;
      } else {
        return 1;
      }
    }

    @Override
    public boolean equals(Object o){
      if(o instanceof Path){
        Path node = (Path) o;
        return this.start == node.start && this.end == node.end && this.len == node.len;
      }
      return false;
    }
  }


}