
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    List<String> arr = new ArrayList<>();
    for (int i = 0 ; i < n ; i++){
        arr.add(br.readLine());
    }
    solution(arr);
  }


  public static void solution(List<String> arr) {
    PriorityQueue<File> pq = new PriorityQueue<>(File::compareTo);

    arr.forEach(file -> pq.add(new File(file)));
    List<String> answer = new ArrayList<>();
    while(!pq.isEmpty()){
      File file = pq.poll();
      answer.add(file.name);
    }

    answer.forEach(System.out::println);
  }

  public static class File{
    String name;
    List<String> subChars;

    public File(String name){
      this.name = name;
      subChars = new ArrayList<>();

      for(String c : name.split("")){
        // 대문자인지 확인한다
        if(c.charAt(0) >= 'A' && c.charAt(0) <= 'Z'){
          subChars.add(String.valueOf((c.charAt(0) - 'A') *2 ));
        } else if (c.charAt(0) >= 'a' && c.charAt(0) <= 'z'){
          subChars.add(String.valueOf((c.charAt(0) - 'a') *2  + 1));
        } else {
          if(!subChars.isEmpty() && subChars.get(subChars.size() - 1).contains("-")){
            String prev = subChars.get(subChars.size() - 1);
            subChars.set(subChars.size() - 1, prev + c.charAt(0));
          } else {
            subChars.add("-" + c.charAt(0));
          }
        }
      }
    }

    public int compareTo(File p) {
      for(int i = 0 ; i < Math.min(p.subChars.size(), this.subChars.size()) ; i++){
        boolean thisDigit = this.subChars.get(i).contains("-");
        boolean pDigit = p.subChars.get(i).contains("-");
        if(thisDigit && pDigit ) { // 둘 다 마이너스
          String cleanThis = this.subChars.get(i).replaceAll("^-0*", "");
          String cleanP = p.subChars.get(i).replaceAll("^-0*", "");
          if(cleanThis.length() < cleanP.length()){
            return -1;
          } else if (cleanThis.length() > cleanP.length()){
            return 1;
          }

          int l = Math.min(cleanThis.length(), cleanP.length());
          for (int j = 0; j < l; j++) {
            if (cleanThis.charAt(j) < cleanP.charAt(j)) {
              return -1;
            } else if (cleanThis.charAt(j) > cleanP.charAt(j)) {
              return 1;
            }
          }

          if(this.subChars.get(i).length() < p.subChars.get(i).length()){
            return -1;
          } else if (this.subChars.get(i).length() > p.subChars.get(i).length()){
            return 1;
          }

        } else if (thisDigit && !pDigit){ // this만 숫자, p는 문자
          return -1;
        } else if (!thisDigit && pDigit) { // this는 문자, p는 숫자
          return 1;
        } else if (Double.parseDouble(this.subChars.get(i)) < Double.parseDouble(p.subChars.get(i))) { // 둘다 문자
          return -1;
        } else if (Double.parseDouble(this.subChars.get(i)) > Double.parseDouble(p.subChars.get(i))){
          return 1;
        }
      }

      return this.subChars.size() < p.subChars.size() ? -1 : 1;
    }
  }



}