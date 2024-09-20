import java.util.*;
import  java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> dup = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        Set<Integer> re = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        dup.retainAll(re);
        re.removeAll(dup);
        int answer = n - lost.length + dup.size();
        
        // lost를 순회하면서 (reserve에 앞뒤로가 있는지 있으면 이게 dup에는 없는지) 확인한다
        // 조건을 만족하면 reserve에 해당 idx 지우면서 answer +1
        // System.out.println(answer);
        Arrays.sort(lost);
        for(int i = 0 ; i < lost.length; i++){
            if(dup.contains(lost[i])){
                continue;
            }
            if(re.contains(lost[i]-1)){
                re.remove(lost[i]-1);
                answer += 1;
                // System.out.println(lost[i] + "-");
            } else if(re.contains(lost[i]+1)){
                re.remove(lost[i]+1);
                answer += 1;
                // System.out.println(lost[i] + "+");
            }
        }

        return answer;
    }
}