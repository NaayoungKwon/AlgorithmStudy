import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        
        int n = maps.length, m  = maps[0].length;
        List<Node> dirs = initDir();
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0,0,1));
        if(maps[0][0] == 0 || maps[n-1][m-1] == 0){
            return -1;
        }
        
        while(que.size() > 0){
            Node node = que.remove();
            for(int i = 0 ; i < 4; i++){
                int x = node.x + dirs.get(i).x;
                int y = node.y + dirs.get(i).y;
                if(x < 0 || x >= n || y < 0 || y >=m || maps[x][y] == 0){
                    continue;
                }
                if(x == n-1 && y == m-1){
                    return node.len + 1;
                }
                maps[x][y] = 0;
                que.add(new Node(x,y,node.len+1));
            }
        }
        
        return -1;
    }
    
    public static class Node{
        public int x;
        public int y;
        public int len;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Node(int x, int y, int l){
            this.x = x;
            this.y = y;
            this.len = l;
        }
    }
    
    public List<Node> initDir(){
        List<Node> dirs = new ArrayList<>();
        dirs.add(new Node(1, 0));
        dirs.add(new Node(-1, 0));
        dirs.add(new Node(0, -1));
        dirs.add(new Node(0, 1));
        return dirs;
    }
}