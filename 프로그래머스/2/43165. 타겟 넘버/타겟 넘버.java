import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // st에 우선 첫 번째꺼 -,+ 인거 둘다 넣어놔
        // 하나 씩 빼면서 계속 추가해
        // 끝까지 왔을 때 타겟과 맞으면 +1
        int n = numbers.length;
        Stack<Node> st = new Stack<>();
        st.add(new Node(numbers[0], 0));
        st.add(new Node(-numbers[0], 0));
        
        while(st.size()>0){
            Node node = st.pop();
            if(node.idx == n-1){
                answer += (node.now == target ? 1 : 0);
                continue;
            }
            int next = node.idx+1;
            st.add(new Node(node.now + numbers[next] , next));
            st.add(new Node(node.now - numbers[next] , next));
        }
        
        return answer;
    }
    
    public static class Node{
        int now;
        int idx;
        Node(int now, int idx){
            this.now = now;
            this.idx = idx;
        }
    }
}