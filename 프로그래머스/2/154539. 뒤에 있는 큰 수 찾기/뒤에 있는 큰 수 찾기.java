import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Node> stack = new Stack<>();
        for(int i = 0 ; i < numbers.length ; i++){
            while(!stack.isEmpty() && stack.peek().y < numbers[i]){
                Node node = stack.pop();
                answer[node.x] = numbers[i];
            }
            stack.add(new Node(i, numbers[i]));
        }
        while(!stack.isEmpty()){
            Node node = stack.pop();
            answer[node.x] = -1;
        }
        return answer;
    }
    
    public static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}