
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
    List<Class> classes = new ArrayList<>();
    for (int i = 0 ; i < n ; i++){
      String[] split1 = br.readLine().split(" ");
      classes.add(new Class(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]), Integer.parseInt(split1[2])));
    }

    System.out.println(solution(n, classes));
//    solution(n, classes);

  }


  public static int solution(int n, List<Class> classes) {
    int count = 0;
    PriorityQueue<Class> que = new PriorityQueue<>(Class::compareTo);
    PriorityQueue<Integer> lastClass = new PriorityQueue<>(Integer::compareTo);

    que.addAll(classes);
    while(!que.isEmpty()){
      Class thisClass = que.poll();
      if(lastClass.isEmpty()){
        lastClass.add(thisClass.end);
        count++;
      } else{
        if(lastClass.peek() <= thisClass.start){
          lastClass.poll();
          lastClass.add(thisClass.end);
        } else{
            lastClass.add(thisClass.end);
            count++;
        }
      }
    }
    return count;
  }

  public static class Class{
    int num;
    int end;
    int start;

    public Class(int num, int start, int end){
      this.num = num;
      this.start = start;
      this.end = end;
    }

    public int compareTo(Class p){
      if(this.start < p.start){
        return -1;
      } else if(this.start == p.start){
        if(this.end < p.end){
          return -1;
        }
      }
      return 1;
    }
  }

  


}