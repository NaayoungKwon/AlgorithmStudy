import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();

        int l = queue1.length;
        long target = 0, s1 = 0, s2= 0;
        for(int i = 0 ; i < l ; i++){
            Q1.add(queue1[i]);
            s1 += queue1[i];
        }
        for(int i = 0 ; i < l ; i++){
            Q2.add(queue2[i]);
            s2 += queue2[i];
        }
        target = s1 + s2;
        if(target % 2 == 1){
            return -1;
        }
        target /= 2;

        while(answer <= l*3){
            if(s1 == target){
                return answer;
            }
            if(s1 < target){
                Integer e = Q2.poll();
                Q1.add(e);
                s2 -= e;
                s1 += e;
            } else if (s2 < target){
                Integer e = Q1.poll();
                Q2.add(e);
                s1 -= e;
                s2 += e;
            }
            answer += 1;
        }
        return -1;
    }

}