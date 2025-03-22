import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        int n = 0;
        int m = 0;

        for(int[] rec : rectangle){
            n = Math.max(n, Math.max(rec[0], rec[2]));
            m = Math.max(m, Math.max(rec[1], rec[3]));
        }

        boolean[][] visited = new boolean[n*2+1][m*2+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int[] dir : dirs){
                int cx = cur[0] + dir[0];
                int cy = cur[1] + dir[1];

                if(cx < 0 || cx > n*2 || cy < 0 || cy > m*2 || visited[cx][cy]){
                    continue;
                }

                if( !isEdge(rectangle, cx, cy)){
                    continue;
                }
//                System.out.println("x :"  + cur[0] + ", y : " + cur[1] + ", cx : " + cx + ", cy : " + cy);


                if(cx == itemX*2 && cy == itemY*2){
                    return cur[2]/2 + 1;
                }

                visited[cx][cy] = true;
                queue.add(new int[]{cx, cy, cur[2]+1});
            }
        }
        return answer;
    }

    private boolean isEdge(int[][] rectangle, int x ,int y){
        boolean isEdge = false;
        boolean isIn = false;
        for(int[] rec : rectangle){
            int minX = Math.min(rec[0], rec[2]) * 2;
            int maxX = Math.max(rec[0], rec[2]) * 2;
            int minY = Math.min(rec[1], rec[3]) * 2;
            int maxY = Math.max(rec[1], rec[3]) *2;
            if((x == minX && (y >= minY && y <= maxY) || (x == maxX && (y >= minY && y <= maxY)))) {
                isEdge = true;
            } else if ((x > minX && x < maxX &&  y == minY) || ((x > minX && x < maxX &&  y == maxY))){
                isEdge = true;
            } else if (x > minX && x < maxX && y > minY && y < maxY){
                isIn = true;
            }
        }

        if(isEdge && isIn){
//            System.out.println("x : " + x + ", y : " + y + " isEdge : " + isEdge + ", isIn : " + isIn);
            return false;
        } else if (isEdge && !isIn){
            return true;
        }

        return false;
    }
}