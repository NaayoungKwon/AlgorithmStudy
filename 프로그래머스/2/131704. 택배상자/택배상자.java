import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // 컨테이너 벨트 는 큐
        // 보조 컨테이너 베트는 스택
        Queue<Integer> belt = new LinkedList<>();
        Stack<Integer> subBelt = new Stack<>();
        
        for(int i = 1; i <= order.length ; i++){
            belt.add(i);
        }

        for(int o : order){
            if(!subBelt.isEmpty() && subBelt.peek() == o){
                answer += 1;
                subBelt.pop();
                continue;
            }

            while(!belt.isEmpty() && belt.peek() != o){
                subBelt.add(belt.poll());
            }

            if(!belt.isEmpty() && belt.peek() == o){
                belt.poll();
                answer += 1;
            } else {
                break;
            }
        }
        return answer;
    }
}