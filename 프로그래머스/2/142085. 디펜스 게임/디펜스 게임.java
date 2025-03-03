import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> hp = new PriorityQueue<>();
        if(enemy.length <= k){
            return enemy.length;
        }

        for(int i = 0 ; i < enemy.length ; i++){
            if(hp.size() < k){
                hp.add(enemy[i]);
            } else {
                hp.add(enemy[i]);
                n -= hp.poll();
                if(n < 0){
                    return i;
                }
            }
        }
        return enemy.length;
    }
}