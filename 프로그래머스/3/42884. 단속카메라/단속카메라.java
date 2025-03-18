import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        PriorityQueue<Route> routeQue = new PriorityQueue<>(Route::compareTo);

        int n = routes.length;
        for(int[] route : routes){
            routeQue.add(new Route(route[0], route[1]));
        }

        answer += 1;
        int prevEndPoint = routeQue.poll().end;
        while(!routeQue.isEmpty()){
            Route route = routeQue.poll();
            if(route.isOutOfRange(prevEndPoint)){
                answer += 1;
                prevEndPoint = route.end;
            }
        }

        
        return answer;
    }

    public static class Route{
        int start;
        int end;

        public Route(int start, int end){
            this.start = start;
            this.end = end;
        }

        public boolean isOutOfRange(int point){
            return !(this.start <= point && point <= this.end);
        }

        public int compareTo(Route route){
            if(this.end != route.end){
                return this.end - route.end;
            }
            return this.start - route.start;
        }
    }
}