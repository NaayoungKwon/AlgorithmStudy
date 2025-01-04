import java.io.*;
import java.util.*;



public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < t ; i++){
      int k = Integer.parseInt(br.readLine());
      String[] arr = new String[2];

      PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
      PriorityQueue<Integer> minPQ = new PriorityQueue<>();
      Map<Integer, Integer> count = new HashMap<>();

      for(int j = 0 ; j < k ; j++){
        String[] split = br.readLine().split(" ");
        arr[0] = split[0];
        arr[1] = split[1];

        if (arr[0].equals("I")){
          int num = Integer.parseInt(arr[1]);
          maxPQ.add(num);
          minPQ.add(num);
          count.put(num, count.getOrDefault(num, 0) + 1);
        } else if (arr[1].equals("-1")){
          while(!minPQ.isEmpty()){
            int num = minPQ.poll();
            if(count.containsKey(num) && count.get(num) > 0){
              count.put(num, count.get(num) - 1);
              break;
            } else if (count.containsKey(num) && count.get(num) == 0){
              count.remove(num);
            }
          }
        } else {
          while(!maxPQ.isEmpty()){
            int num = maxPQ.poll();
            if(count.containsKey(num) && count.get(num) > 0){
              count.put(num, count.get(num) - 1);
              break;
            } else if (count.containsKey(num) && count.get(num) == 0){
              count.remove(num);
            }
          }
        }
      }

      int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
      boolean flag = false;
      while(!maxPQ.isEmpty()) {
        int num = maxPQ.poll();
        if (count.getOrDefault(num, 0) > 0) {
          max = num;
          flag = true;
          break;
        }
      }
      while(!minPQ.isEmpty()){
        int num = minPQ.poll();
        if(count.getOrDefault(num, 0) > 0){
          min = num;
          flag = true;
          break;
        }
      }
      if(flag){
        System.out.println(max + " " + min);
      } else {
        System.out.println("EMPTY");
      }

    }
  }
}