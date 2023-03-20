import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] ss = s.split("");
        String first = ss[0];
        int firstCnt = 0;
        int notCnt = 0;
        for(int i = 0 ; i < s.length() ; i ++){
            if(firstCnt == 0){
                firstCnt = 1;
                first = ss[i];
                continue;
            }
            if(first.equals(ss[i])){
                firstCnt += 1;
            } else{
                notCnt += 1;
            }
            if(firstCnt == notCnt){
                answer += 1;
                firstCnt = 0;
                notCnt = 0;
                // System.out.println(i + ss[i]);
            }
            
        }
        if(firstCnt > 0){
            answer += 1;
        }
        return answer;
    }

    public boolean findSame(Map<String, Integer> map, int value){
        for (Map.Entry<String, Integer> entry : map.entrySet()) {//key와 value 모두 필요시
            if (entry.getValue() == value + 1) {
                return true;
            }
        }
        return false;
    }
}