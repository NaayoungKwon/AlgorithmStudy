import java.io.*;
import java.util.*;



public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    int[] nums = new int[(n/2) +1];
    String[] exp = new String[n/2];
    String[] s = br.readLine().split("");
    for(int i = 0 ; i < n ; i++){
      if(i % 2 == 0){
        nums[i/2] = Integer.parseInt(s[i]);
      } else {
        exp[i/2] = s[i];
      }
    }

    solution(n, nums, exp);
  }



  public static void solution(int n, int[] nums, String[] exp){
    if(n == 1){
      System.out.println(nums[0]);
      return;
    }
    List<N> queue = new ArrayList<>();
    int result = Integer.MIN_VALUE;
    queue.add(new N(0, false));
    queue.add(new N(0, true));

    while(!queue.isEmpty()){
      N node = queue.remove(0);
      if(node.idx == exp.length-1){
        result = Math.max(result, calculate(nums, exp, node.hasBal));
        continue;
      }

      queue.add(node.next(false));
      if(!node.isBal()) {
        queue.add(node.next(true));
      }
    }
    System.out.println(result);
  }

  private static int calculate(int[] nums, String[] exp, List<Boolean> hasBal) {
    List<Integer> newNums = new ArrayList<>();
    List<String> newExp = new ArrayList<>();
    for(int i = 0 ; i < exp.length ; i++){
      if(hasBal.get(i)){
        newNums.add(cal(nums[i], nums[i+1], exp[i]));
      } else {
        newExp.add(exp[i]);
        if(i == 0 || !hasBal.get(i-1)){
          newNums.add(nums[i]);
        }
        if (i == exp.length-1){
          newNums.add(nums[i+1]);
        }
      }
    }

    int result = newNums.get(0);
    for(int i = 0 ; i < newExp.size() ; i++){
      result = cal(result, newNums.get(i+1), newExp.get(i));
    }
    return result;
  }

  private static int cal(int a, int b, String exp){
    if(exp.equals("+")){
      return a + b;
    } else if(exp.equals("-")){
      return a - b;
    } else {
      return a * b;
    }
  }

  public static class N{
    int idx;
    List<Boolean> hasBal;

    public N(int idx, boolean flag){
      this.idx = idx;
      this.hasBal = new ArrayList<>();
      this.hasBal.add(flag);
    }

    public N(int idx, List<Boolean> hasBal){
      this.idx = idx;
      this.hasBal = hasBal;
    }

    public  N next(boolean flag){
      List<Boolean> list = new ArrayList<>(this.hasBal);
      list.add(flag);
      return new N(this.idx+1, list);
    }

    public boolean isBal(){
      return this.hasBal.get(this.hasBal.size()-1);
    }
  }
}