
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


    int n = Integer.parseInt(br.readLine());

    List<Integer> w = new ArrayList<>();
    int[][] p = new int[n][n];
    for (int i = 0 ; i < n ; i++){
      w.add(Integer.parseInt(br.readLine()));
    }

    for (int i = 0 ; i < n ; i++){
      String[] split = br.readLine().split(" ");
      for(int j = 0 ; j < n ; j++){
        p[i][j] = Integer.parseInt(split[j]);
      }
    }

    System.out.println(solution(n, w, p));

  }



  public static int solution(int n, List<Integer> w, int[][] p) {
    int answer = 0;
    boolean[] visited = new boolean[n];
    Arrays.fill(visited, false);

    PriorityQueue<Spot> wQue = new PriorityQueue<>(Spot::compareTo);
    for(int i = 0 ; i < w.size() ; i++){
      wQue.add(new Spot(i, w.get(i)));
    }

    while(!wQue.isEmpty()){
      Spot spot = wQue.poll();
      int index = spot.index;
      int weight = spot.weight;

      if(!visited[index]){
        visited[index] = true;
        answer += weight;
        for(int i = 0 ; i < n ; i++){
          if(!visited[i] && p[index][i] < w.get(i)){
            wQue.add(new Spot(i, p[index][i]));
          }
        }
      }
    }

    for(int i = 0 ; i < n ; i++){
      if(!visited[i]){
        answer += w.get(i);
      }
    }

    return answer;
  }

  public static class Spot{
    int index;
    int weight;

    public Spot(int index, int weight){
      this.index = index;
      this.weight = weight;
    }

    public int compareTo(Spot s){
      if(this.weight < s.weight){
        return -1;
      } else {
        return 1;
      }
    }
  }





}