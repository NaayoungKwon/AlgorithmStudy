
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    List<Work> works = new ArrayList<>();
    for(int i = 0 ; i < n ; i++){
      String[] split = br.readLine().split(" ");
      works.add(new Work(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
    }
    System.out.println(solution(n , works));


  }



  public static int solution(int n, List<Work> works) {
    Collections.sort(works, Work::compareTo);
    int lastTime = works.get(0).end - works.get(0).time;

    for(int i = 1 ; i < n ; i++){
      if(lastTime < works.get(i).end){
        lastTime -= works.get(i).time;
      } else{
        lastTime = works.get(i).end - works.get(i).time;
      }
    }

    return lastTime < 0 ? -1 : lastTime;
  }


  public static class Work{
    int time, end;

    public Work(int time, int end){
      this.time = time;
      this.end = end;
    }

    public int compareTo(Work p){
      if(this.end < p.end){
        return 1;
      } else {
        return -1;
      }
    }

  }
}