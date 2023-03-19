import java.util.*;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        PriorityQueue<Node> pq=new PriorityQueue<>(Node::compareTo);
        for(int e : numlist){
            Node node = new Node(e, Math.abs(n-e));
            pq.add(node);
        }
        for(int i = 0 ; i < numlist.length ; i++){
            Node r = pq.poll();
            answer[i] = r.value;
        }
        return answer;
    }
    
    public class Node{
        int value, l;
        Node(int value, int l){
            this.value = value;
            this.l = l;
        }

        public int compareTo(Node p) {
            if(this.l < p.l) {
                return -1; // 오름차순
            }
            else if(this.l == p.l) {
                if(this.value > p.value) {
                    return -1;
                }
            }
            return 1;
        }
    }
}