import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        int n = routes.length;
        PriorityQueue<Route> pq = new PriorityQueue<Route>(Route::compareTo);
        for(int i = 0 ; i < n ; i++){
            pq.add(new Route(routes[i][0], routes[i][1]));
        }
        int end = pq.poll().end;
        while (!pq.isEmpty()) {
            Route route = pq.poll();
            if(end < route.start){
                answer++;
                end = route.end;
            }
        }
        return answer;
    }
    
    public static class Route{
        int start;
        int end;

        Route(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Route other){
            if(this.end == other.end) {
                return -(this.start - other.start);
            }
            return this.end - other.end;
        }
    }
}