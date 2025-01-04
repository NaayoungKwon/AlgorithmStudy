import java.io.*;
import java.util.*;


public class Main {

  private static BufferedReader br;
  private static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][n];

    for(int i = 0 ; i < n ; i++){
      String[] split = br.readLine().split(" ");
      for(int j = 0 ; j < n ; j++){
        arr[i][j] = Integer.parseInt(split[j]);
      }
    }

    solution(n, arr);
  }



  public static void solution(int n ,int[][] arr) {
    int sharkSize = 2;
    int sharkEat = 0;
    int time = 0;
    List<Fish> fishes = new ArrayList<>();
    Node shark = null;

    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        if(arr[i][j] == 9){
          shark = new Node(i, j);
          arr[i][j] = 0;
        }else if(arr[i][j] != 0){
          fishes.add(new Fish(i, j, arr[i][j]));
        }
      }
    }
    fishes.sort(Comparator.comparingInt(Fish::getSize));
    while(!fishes.isEmpty()){
      Fish removable = null;
      int min_dist = Integer.MAX_VALUE;
      for(Fish fish : fishes){
        if(fish.size < sharkSize){
          int dist = getDist(shark, fish, arr, n, sharkSize);
          if(dist <= 0){
            continue;
          } else if (removable == null || dist < min_dist || (dist == min_dist && (fish.x < removable.x  || (fish.x == removable.x && fish.y < removable.y)))){
            removable = fish;
            min_dist = dist;
          }
        } else {
          break;
        }
      }
      if(removable == null){
        break;
      } else {
        fishes.remove(removable);
        arr[removable.x][removable.y] = 0;
        time += min_dist;
        sharkEat += 1;
        if(sharkEat == sharkSize){
          sharkEat = 0;
          sharkSize += 1;
        }
        shark = new Node(removable.x, removable.y);
      }
    }
    System.out.println(time);

  }

  private static int getDist(Node shark, Fish fish, int[][] arr, int n, int size) {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    boolean[][] visited = new boolean[n][n];
    List<Fish> que = new ArrayList<>();
    que.add(new Fish(shark.x, shark.y, 0));
    visited[shark.x][shark.y] = true;
    while(!que.isEmpty()){
      Fish node = que.remove(0);
      for(int[] dir : dirs){
        int nx = node.x + dir[0];
        int ny = node.y + dir[1];
        if(nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] <= size && !visited[nx][ny]){
          if(nx == fish.x && ny == fish.y){
            return node.size + 1;
          }
          visited[nx][ny] = true;
          que.add(new Fish(nx, ny, node.size + 1));
        }
      }
    }
    return 0;
  }

  public static class Fish{
    int x;
    int y;
    int size;

    public Fish(int x, int y,int size){
      this.x = x;
      this.y = y;
      this.size = size;
    }

    public int getSize() {
      return size;
    }

    @Override
    public boolean equals(Object o){
      if(o instanceof Fish){
        Fish node = (Fish) o;
        return this.x == node.x && this.y == node.y && this.size == node.size;
      }
      return false;
    }

    @Override
    public int hashCode(){
      return x * 1000 + y;
    }
  }

  public static class Node{
    int x;
    int y;

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o){
      if(o instanceof Node){
        Node node = (Node) o;
        return this.x == node.x && this.y == node.y;
      }
      return false;
    }

    @Override
    public int hashCode(){
      return x * 1000 + y;
    }
  }
}