import java.util.*;
class Solution {
    
    public int solution(String[] storage, String[] requests) {
        int answer = storage.length * storage[0].length();
        Map<String, Set<Node>> letterMap = new HashMap<>();
        for(int i = 0 ; i < storage.length ; i++){
            for(int j = 0 ; j < storage[i].length() ; j++){
                String letter = storage[i].substring(j, j+1);
                Set<Node> nodes = letterMap.getOrDefault(letter, new HashSet<>());
                nodes.add(new Node(i, j));
                letterMap.put(letter, nodes);
            }
        }

        Set<Node> empty = new HashSet<>();
        int n  = storage.length, m = storage[0].length();
        for(String request : requests){
            if(request.length() == 1){
                Set<Node> willRemove = new HashSet<>();
                for(Node node : letterMap.getOrDefault(request, new HashSet<>())){
                    if(checkEdge(empty, node, n, m)){
                        willRemove.add(node);
                    }
                }
                empty.addAll(willRemove);
                Set<Node> ls = letterMap.getOrDefault(request, new HashSet<>());
                ls.removeAll(willRemove);
                letterMap.put(request, ls);

            } else {
                String letter = request.substring(0,1);
                empty.addAll(letterMap.getOrDefault(letter, new HashSet<>()));
                letterMap.put(letter, Collections.emptySet());
            }
//            System.out.println(empty);
        }
        return answer - empty.size();
    }

    private boolean checkEdge(Set<Node> empty, Node node, int n, int m) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if(node.x == 0 || node.x == n-1 || node.y == 0 || node.y == m-1){
            return true;
        }

        boolean[][] visited = new boolean[n][m];
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        visited[node.x][node.y] = true;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int[] dir : dirs){
                int nx = cur.x + dir[0];
                int ny = cur.y + dir[1];
                if(nx < 0 || nx > n-1 || ny < 0 || ny > m-1){
                    return true;
                } else if (empty.contains(new Node(nx, ny)) && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                }
            }
        }

        return false;
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
            return this.x * 100 + this.y;
        }

    }
}