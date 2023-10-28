
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();
  static StringBuilder S;
  static StringBuilder T;

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] pan = new int[n][n];

    for(int i = 0 ; i < n ; i ++){
      String[] line = br.readLine().split(" ");
      for(int j = 0 ; j < line.length ; j++){
        pan[i][j] = Integer.parseInt(line[j]);
      }
    }

    System.out.println(solution(n, pan));
  }


  public static int solution(int n , int[][] pan) {
    int result = 0;
    for(int i = 0 ; i < Math.pow(4,5); i++){
      List<Integer> curList = makeCurList(i);
      int[][] newPan = new int[n][n];
      for (int j = 0; j < n; j++) {
        System.arraycopy(pan[j], 0, newPan[j], 0, n);
      }

      curList.forEach(cur -> {
        if(cur == 0){ // 왼쪽으로
          // 이동
          for(int a = 0 ; a < n ; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = 0 ; b < n ; b++){
              if(newPan[a][b] != 0 && !lastIdxes.isEmpty()){
                newPan[a][lastIdxes.get(0)] = newPan[a][b];
                newPan[a][b] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[a][b] == 0 ){
                lastIdxes.add(b);
              }
            }
          }

          // 합치기
          for(int a = 0 ; a < n ; a++){
            for(int b = 0 ; b < n-1 ; b++){
              if(newPan[a][b] != 0 && newPan[a][b] == newPan[a][b+1]){
                newPan[a][b] *= 2;
                newPan[a][b+1] = 0;
              }
            }
          }

          // 재이동
          for(int a = 0 ; a < n ; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = 0 ; b < n ; b++){
              if(newPan[a][b] != 0 && !lastIdxes.isEmpty()){
                newPan[a][lastIdxes.get(0)] = newPan[a][b];
                newPan[a][b] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[a][b] == 0 ){
                lastIdxes.add(b);
              }
            }
          }
        } else if (cur == 1){ // 오른쪽으로
          for(int a = 0 ; a < n; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = n -1 ; b > -1 ; b--){
              if(newPan[a][b] != 0 && !lastIdxes.isEmpty()){
                newPan[a][lastIdxes.get(0)] = newPan[a][b];
                newPan[a][b] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[a][b] == 0 ){
                lastIdxes.add(b);
              }
            }
          }

          // 합치기
          for(int a = 0 ; a < n ; a++){
            for(int b = n-1 ; b > 0 ; b--){
              if(newPan[a][b] != 0 && newPan[a][b] == newPan[a][b-1]){
                newPan[a][b] *= 2;
                newPan[a][b-1] = 0;
              }
            }
          }

          for(int a = 0 ; a < n; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = n -1 ; b > -1 ; b--){
              if(newPan[a][b] != 0 && !lastIdxes.isEmpty()){
                newPan[a][lastIdxes.get(0)] = newPan[a][b];
                newPan[a][b] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[a][b] == 0 ){
                lastIdxes.add(b);
              }
            }
          }
        } else if (cur == 2){
          for(int a = 0 ; a < n; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = n -1 ; b > -1 ; b--){
              if(newPan[b][a] != 0&& !lastIdxes.isEmpty()){
                newPan[lastIdxes.get(0)][a] = newPan[b][a];
                newPan[b][a] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[b][a] == 0){
                lastIdxes.add(b);
              }
            }
          }

          // 합치기
          for(int a = 0 ; a < n ; a++){
            for(int b = n-1 ; b > 0 ; b--){
              if(newPan[b][a] != 0 && newPan[b][a] == newPan[b-1][a]){
                newPan[b][a] *= 2;
                newPan[b-1][a] = 0;
              }
            }
          }


          for(int a = 0 ; a < n; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = n -1 ; b > -1 ; b--){
              if(newPan[b][a] != 0&& !lastIdxes.isEmpty()){
                newPan[lastIdxes.get(0)][a] = newPan[b][a];
                newPan[b][a] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[b][a] == 0){
                lastIdxes.add(b);
              }
            }
          }
        } else if (cur == 3){
          for(int a = 0 ; a < n; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = 0 ; b < n ; b++){
              if(newPan[b][a] != 0 && !lastIdxes.isEmpty()){
                newPan[lastIdxes.get(0)][a] = newPan[b][a];
                newPan[b][a] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[b][a] == 0){
                lastIdxes.add(b);
              }
            }
          }

          // 합치기
          for(int a = 0 ; a < n ; a++){
            for(int b = 0 ; b < n-1 ; b++){
              if(newPan[b][a] != 0 && newPan[b][a] == newPan[b+1][a]){
                newPan[b][a] *= 2;
                newPan[b+1][a] = 0;
              }
            }
          }

          for(int a = 0 ; a < n; a++){
            List<Integer> lastIdxes = new ArrayList<>();
            for(int b = 0 ; b < n ; b++){
              if(newPan[b][a] != 0 && !lastIdxes.isEmpty()){
                newPan[lastIdxes.get(0)][a] = newPan[b][a];
                newPan[b][a] = 0;
                lastIdxes.add(b);
                lastIdxes.remove(0);
              } else if (newPan[b][a] == 0){
                lastIdxes.add(b);
              }
            }
          }
        }
      });

      for(int j = 0 ; j < n ; j ++){
        result = Math.max(result, Arrays.stream(newPan[j]).max().getAsInt());
      }

    }

    return result;
  }


  public static List<Integer> makeCurList(int i){
    List<Integer> curList = new ArrayList<>();
    int cur = i;
    while(cur > 0){
      curList.add(cur % 4);
      cur /= 4;
    }
    while(curList.size() < 5){
      curList.add(0);
    }
    return curList;
  }
}