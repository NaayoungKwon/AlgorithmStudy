
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    String[] split = br.readLine().split(" ");
    int k = Integer.parseInt(split[0]);
    int n = Integer.parseInt(split[1]);
    List<Integer> arr = new ArrayList<>();
    for(int i = 0 ; i < k ; i++){
      int T = Integer.parseInt(br.readLine());
      arr.add(T);
    }
    System.out.println(solution(k, n, arr));
  }


  public static int solution(int k , int n , List<Integer> arr) {
    int answer = 0;
    int target = Collections.min(arr);
    int left = 1;
    int right = Collections.max(arr);

    while(left < right){
      int result = calculate(target, arr);
      if(result < n){ // 더 작게 나눠야함
        right = target;
        target = (left + target) / 2;
        if(right == target){
          break;
        }
      } else if (result > n) { // 더 크게 나누기
        left = target;
        target = (right + target) / 2;
        if (left == target){
          break;
        }
      } else{
        break;
      }
    }

    while(calculate(target+1, arr) == n){
      target++;
    }
    return target;
  }

  public static int calculate(int target, List<Integer> arr){
    int sum = 0;
    for(int i = 0 ; i < arr.size() ; i++){
      sum += arr.get(i) / target;
    }
    return sum;
  }
}