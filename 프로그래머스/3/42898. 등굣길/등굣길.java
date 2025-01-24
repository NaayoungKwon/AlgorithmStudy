import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        dp[1][1] = 1;
        Set<Node> puddleSet = new HashSet<>();
        for(int i = 0 ; i < puddles.length ; i++){
          puddleSet.add(new Node(puddles[i][0], puddles[i][1]));
        }
        for(int i = 1 ; i <= m ; i++){
          for(int j = 1 ; j <= n ; j++){
            if(i == 1 && j == 1){
              continue;
            }
            if(puddleSet.contains(new Node(i, j))){
              dp[i][j] = 0;
            } else {
              dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
          }
        }
        return dp[m][n];
    }
    
    public static class Node{
    int x;
    int y;

    public Node(int x, int y){
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
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