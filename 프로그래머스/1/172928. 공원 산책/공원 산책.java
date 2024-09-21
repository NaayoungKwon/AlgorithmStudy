import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int sx = -1, sy = -1;
        int h= park.length, w = park[0].length();
        Map<String, DIR> dirs = new HashMap<>();
        dirs.put("E", new DIR(0,1));
        dirs.put("W", new DIR(0,-1));
        dirs.put("N", new DIR(-1,0));
        dirs.put("S", new DIR(1,0));
        
        for(int i = 0 ; i < h ; i++){
            if(sx != -1){
                break;
            }
            
            for(int j = 0 ; j < w ; j++){
                if(park[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                    break;
                }
            }
        }
        
        for(int a = 0 ; a < routes.length ; a++){
            String[] r = routes[a].split(" ");
            DIR d = dirs.get(r[0]);
            int n = Integer.parseInt(r[1]);
            int mx = d.x * n, my = d.y * n;
            if(sx + mx < 0 || sx + mx >= h || sy + my < 0 || sy +my >= w ){
                continue;
            }
            boolean flag = true;
            for(int i = 1 ; i <= n ; i++){
                if(park[sx+d.x *i].charAt(sy+d.y*i) == 'X'){
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                continue;
            }
            sx += mx;
            sy += my;
            // System.out.println(sx + " " + sy);
        }
        
        answer[0] = sx;
        answer[1] = sy;
        return answer;
    }
    
    public static class DIR{
        public int x;
        public int y;
        
        public DIR(int nx, int ny){
            this.x = nx;
            this.y = ny;
        }
    }
}