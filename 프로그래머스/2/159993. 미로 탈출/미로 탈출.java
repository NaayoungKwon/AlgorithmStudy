import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        // 시작, 끝, 레버 위치를 구한다.
        Node start = null, end = null, lever = null;
        int n = maps.length, m = maps[0].length();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j  < m ; j++){
                if(maps[i].substring(j, j+1).equals("S")){
                    start = new Node(i, j, 0);
                } else if (maps[i].substring(j, j+1).equals("E")){
                    end = new Node(i, j, 0);
                } else if (maps[i].substring(j, j+1).equals("L")) {
                    lever = new Node(i, j, 0);
                }
            }
        }

        // 시작에서 레버까지 가는데 시간을 구한다
        int a = findPath(maps, start, lever);
        if(a == -1){
            return -1;
        }
        int b = findPath(maps, lever, end);
        if(b == -1){
            return -1;
        }
        // 레버에서 끝까지 가는데 시간을 구한다
        return a+b;
    }

    public int findPath(String[] maps, Node start, Node end){
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int n = maps.length, m = maps[0].length();
        Queue<Node> que  = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            Node cur = que.poll();
            if(cur.equals(end)){
                return cur.time;
            }
            for(int[] dir : dirs){
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m){
                    continue;
                }
                if(maps[nx].substring(ny, ny+1).equals("X") || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                que.add(new Node(nx, ny, cur.time+1));
            }
        }

        return -1;
    }
    
    public static class Node{
        int x;
        int y;
        int time;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
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
            return this.x * 100 + this.y;
        }

        @Override
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }
}