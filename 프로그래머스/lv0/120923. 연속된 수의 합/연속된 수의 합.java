import java.util.*;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        List<Integer> sumList = new ArrayList<Integer>();
        int start = sum(-num, num);
        sumList.add(start);
        int i = -num+1;
        while(true){
            int lastSum = sumList.get(sumList.size()-1);
            int thisSum = lastSum - (i-1) + (i+num-1);
            if(thisSum == total) {
                for(int j = 0 ; j < num ; j++){
                    answer[j] = i+j;
                }
                return answer;
            } else{
                sumList.add(thisSum);
            }
            i += 1;
        }
    }
    
    public int sum(int start, int num){
        int result = 0;
        for(int i = start ; i < start + num ; i++){
            result += i;
        }
        return result;
    }
}