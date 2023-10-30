import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;


  public static void template() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    S = new StringBuilder(br.readLine());
    T = new StringBuilder(br.readLine());
    int T = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));


    System.out.println(solution(Integer.parseInt(br.readLine())));


  }



  public static String solution(int n) {
    StringBuilder sb = new StringBuilder();

    String binaryString = Integer.toBinaryString(n + 1);
    for(int i = 1; i < binaryString.length() ; i++){
      if(binaryString.charAt(i) == '0'){
        sb.append("4");
      } else{
        sb.append("7");
      }
    }

    return sb.toString();
  }
}