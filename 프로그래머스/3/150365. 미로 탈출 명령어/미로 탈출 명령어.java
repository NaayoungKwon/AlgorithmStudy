import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";        
        String[] dirStr = new String[]{"d","l","r","u"};
        int[][] dirs = {{1,0},{0, -1},{0,1},{-1,0}};

        int realk = Math.abs(r-x) + Math.abs(c-y);
        if(realk == k){
            answer = "d".repeat(Math.max(r-x, 0)) + "l".repeat(Math.max(-(c-y), 0)) + "r".repeat(Math.max(c-y,0)) + "u".repeat(Math.max(-(r-x),0));
            return answer;
        } else if ((k-realk) % 2 == 1 || k < realk){
            return "impossible";
        } else {
            int cx = x, cy = y;
            StringBuilder sb = new StringBuilder();
            while (k > 0) {
                for (int i = 0; i < 4; i++) {
                    int nx = cx + dirs[i][0], ny = cy + dirs[i][1];
                    if (nx <= 0 || nx > n || ny <= 0 || ny > m) {
                        continue;
                    }
                    int distance = Math.abs(r - nx) + Math.abs(c - ny);
                    if (distance <= k - 1) {
                        k--;
                        cx = nx;
                        cy = ny;
                        sb.append(dirStr[i]);
                        break;
                    }
                }
            }
            return sb.toString();
        }
    }
    
}