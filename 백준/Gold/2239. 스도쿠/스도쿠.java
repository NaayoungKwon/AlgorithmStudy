
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
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;


  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int[][] pan = new int[9][9];
    for(int i = 0 ; i < 9 ; i ++){
      String line = br.readLine();
      for(int j = 0 ; j < 9 ; j ++){
        pan[i][j] = Integer.parseInt(line.substring(j,j+1));
      }
    }
    solution(pan);

  }


  public static boolean solution( int[][] pan) {

    for(int a = 0 ; a < 9 ; a++){
      for(int b = 0 ; b < 9 ; b++){
        if(pan[a][b] == 0){
          int finalB = b;
          int finalA = a;
          Set<Integer> leftSet = leftSet(pan, a, b);
          if(leftSet.isEmpty()){
            return false;
          }

          Optional<Integer> isSuccess = leftSet.stream().filter(k -> {
            pan[finalA][finalB] = k;
            boolean result = solution(pan);
            if (result) {
              return true;
            }
            pan[finalA][finalB] = 0;
            return false;
          }).findAny();

          if(isSuccess.isEmpty()){
            return false;
          }
          return true;
        }
      }
    }

    if(verify(pan)){
      printPan(pan);
      return true;
    }
    return false;
  }

  public static Set<Integer> leftSet( int[][] pan, int i , int j){
    Set<Integer> set = new HashSet<>();
    for(int k = 0 ; k < 9 ; k ++){
      set.add(pan[i][k]);
    }

    for(int k = 0 ; k < 9 ; k ++){
      set.add(pan[k][j]);
    }

    for(int a = (i/3)*3 ; a < (i/3)*3+3 ; a++){
      for(int b = (j/3)*3 ; b < (j/3)*3+3 ; b++){
        set.add(pan[a][b]);
      }
    }

    Set<Integer> all = new HashSet<>();
    for(int k = 1; k <= 9 ; k ++){
      all.add(k);
    }

    all.removeAll(set);
    return all;
  }

  public static void printPan(int[][] pan){
    for(int i = 0 ; i < 9 ; i ++){
      for(int j = 0 ; j < 9 ; j ++){
        System.out.print(pan[i][j]);
      }
      System.out.println();
    }
  }

  public static boolean verify(int[][] pan){


    for(int k = 0 ; k < 9 ; k ++){
      Set<Integer> s = Arrays.stream(pan[k]).boxed().collect(Collectors.toSet());
      if(s.size() < 9 || s.contains(0)){
        return false;
      }
    }

    for(int k = 0 ; k < 9 ; k ++){
      Set<Integer> s = new HashSet<>();
      for(int l = 0 ; l < 9 ; l ++){
        s.add(pan[l][k]);
      }
      if(s.size() < 9 || s.contains(0)){
        return false;
      }
    }

    for(int k = 0 ; k < 3 ; k ++){
      for(int l = 0 ; l < 3 ; l++){
        Set<Integer> s = new HashSet<>();
        for(int a = k*3 ; a < k*3+3 ; a++){
          for(int b = l*3 ; b < l*3+3 ; b++){
            s.add(pan[a][b]);
          }
        }
        if(s.size() < 9 || s.contains(0)){
          return false;
        }
      }
    }


    return true;
  }
}