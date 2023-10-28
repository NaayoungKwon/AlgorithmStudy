class Solution {
    public int solution(int n, int m, int[] section) {
         int answer = 0;
        int before = 0;

        for(int i = 0 ; i < section.length ; i++){
          if(before < section[i]){
            answer ++;
            before = section[i] + m - 1;
          }
        }
        return answer;
    }
}