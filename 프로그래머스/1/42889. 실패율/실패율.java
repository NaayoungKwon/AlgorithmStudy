import java.util.*;
import java.util.stream.*;
import java.util.function.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer =  new int[N];
        // stage들을 돌면서 시도 횟수와 실패 횟수를 카운팅한다.
        int[] tryCnt = new int[N+2];
        int[] failCnt = new int[N+2];
        for(int i = 0 ; i < stages.length ; i++){
            int stage = stages[i];
            failCnt[stage] += 1;
            for(int j = 1 ; j <= stage ; j++){
                tryCnt[j] += 1;
            }
        
        }
        
        // 카운팅한걸 순회하면서 node를 만든다.
        List<Node> nodes = new ArrayList<>();
        for(int i = 1 ; i <= N ; i++){
            // System.out.println(i +" " +failCnt[i] +" "+tryCnt[i]);
            if(tryCnt[i] == 0){
                nodes.add(new Node(i, 0L));
            }
            else {
                nodes.add(new Node(i, ((double)failCnt[i]/(double)tryCnt[i])));
            }
            
        }
        
        // 정렬한다.
        Collections.sort(nodes, (e1, e2) -> {
            double m = e1.rate - e2.rate;
            if(m == 0){
                return e1.index - e2.index;
            }
            return m > 0 ? -1 : 1;
        });
        

        // 정렬 순서대로 answer에 index를 넣는다.
        for(int i = 0 ; i < N ; i++){
            answer[i] = nodes.get(i).index;
        }
        return answer;
    }
    
    public static class Node {
        int index;
        double rate;
        
        public Node(int index, double rate){
            this.index = index;
            this.rate = rate;
        }
    }
}