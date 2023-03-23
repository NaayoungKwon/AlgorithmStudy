import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        // 시작 시간을 기준으로 A heapq에 넣는다. (+10분 더해서)
        // 하나 씩 빼면서 B heapq에 넣는데, 여기는 끝나는 시간만 넣는다.
        // B의 최 상단을 봤을 때 현재 A에서 뺀 것의 시작 시간보다 늦으면 걍 추가하고
        // a 시작시간보다 빠르면 뺀다음 a의 종료시간을 다시 넣는다.
        PriorityQueue<Node> pq1=new PriorityQueue<>(Node::compareTo);
        for(int i = 0 ; i < book_time.length ; i++){
            Node time = new Node(book_time[i][0], book_time[i][1]);
            pq1.add(time);
        }
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        pq2.add(pq1.poll().end);
        while(pq1.isEmpty() == false){
            Node top = pq1.poll();
            if(pq2.peek() <= top.start) {
                pq2.poll();
            }
            pq2.add(top.end);
        }
        return pq2.size();
    }

    public class Node{
        int start;
        int end;
        Node(String start, String end){
            String[] st = start.split(":");
            this.start = Integer.parseInt(st[0]) * 100 + Integer.parseInt(st[1]);
            String[] et = end.split(":");
            if(Integer.parseInt(et[1]) >= 50){
                this.end = (Integer.parseInt(et[0])+1) * 100 + Integer.parseInt(et[1]) - 50;
            } else {
                this.end = Integer.parseInt(et[0]) * 100 + Integer.parseInt(et[1]) + 10;
            }
        }

        public int compareTo(Node p) {
            if(this.start < p.start) {
                return -1; // 오름차순
            }
            else if(this.start == p.start) {
                if(this.end < p.end) {
                    return -1;
                }
            }
            return 1;
        }
    }
}