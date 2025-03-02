import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = points.length;
        int robots_cnt = routes.length;

        // 로봇 별로 움직이는 최단거리에 대한 List를 만들어둔다.
        List<List<Node>> robotRoutes = new ArrayList<>();
        for(int i = 0 ; i < robots_cnt; i++){
            List<Node> totalRoute = new ArrayList<>();
            for(int j = 0 ; j < routes[i].length-1 ; j++){
                int[] startPoint = points[routes[i][j] -1];
                int[] endPoint = points[routes[i][j+1] -1];
                Node start = new Node(startPoint[0], startPoint[1]);
                Node end = new Node(endPoint[0], endPoint[1]);
                List<Node> robotRoute = findShortestRoute(start, end);
                if(j == 0){
                    totalRoute.add(start);
                }
                totalRoute.addAll(robotRoute.subList(1, robotRoute.size()));
            }
            robotRoutes.add(totalRoute);
        }

        // 노드 한 개씩보면서 충돌하는 곳이 있는지 확인해서 값을 1 씩 더한다
        int i = 0;
        while(true){
            Map<Node, Integer> nodeSet = new HashMap<>();
            int checkNodeCnt = 0;
            for(List<Node> robot : robotRoutes){
                if(i < robot.size()){
                    checkNodeCnt += 1;
                    nodeSet.put(robot.get(i), nodeSet.getOrDefault(robot.get(i), 0) + 1);
                }
            }
            if(checkNodeCnt == 0){
                break;
            }
            for(Map.Entry<Node, Integer> entry : nodeSet.entrySet()){
                if(entry.getValue() > 1){
                    // System.out.println("crash at "+  i + " " + entry.getKey() + " : " + entry.getValue());
                    answer += 1;
                }
            }
            i++;
        }
        return answer;
    }

    private List<Node> findShortestRoute(Node start, Node end) {
        List<Node> route = new ArrayList<>();
        int[][] dirs = new int[2][];
        if(start.x < end.x){
            dirs[0] = new int[]{1, 0};
        } else if (start.x > end.x){
            dirs[0] = new int[]{-1, 0};
        }

        if(start.y < end.y){
            dirs[1] = new int[]{0, 1};
        } else if (start.y > end.y){
            dirs[1] = new int[]{0, -1};
        }

        int l = 0;
        while(start.x != end.x){
            Node next = new Node(start.x + dirs[0][0] * l , start.y);
            route.add(next);
            if(next.x == end.x){
                break;
            }
            l += 1;
        }
        l = 0;
        while(start.y != end.y){
            Node next = new Node(end.x, start.y + dirs[1][1] * l);
            if(route.isEmpty() ||  !route.get(route.size()-1).equals(next)){
                route.add(next);
            }
            if(next.y == end.y){
                break;
            }
            l += 1;
        }
        return route;
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

        @Override
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }
}