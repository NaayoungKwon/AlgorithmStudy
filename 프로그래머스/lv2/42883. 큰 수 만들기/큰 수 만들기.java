import java.util.*;

class Solution {
    boolean[] visited;
    int cnt = 0;
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        // number를 배열로 만든다.
        String[] numbers = number.split("");
        int n = numbers.length;
        visited = new boolean[n];
        // 0 ~ 끝 중에서 가장 큰 값을 찾는다.
        // 큰 값 (index = i)을 visited에 추가한다.
        // i+1 ~ 끝 에서 또 큰 값을 찾는다. -> 재귀
        // 를 반복하면서 visited에 n-k개 만큼 차면 끝낸다.
        rec(numbers, 0, n-1, n, k);
        // 안차고 완전 끝까지 갔으면 왼쪽을 본다.
        for(int i = 0 ; i < n ; i++){
            if(visited[i]){
                answer.append(numbers[i]);
            }
        }
        return answer.toString();
    }

    public void rec(String[] numbers, int start, int end, int n, int k){
        if(start> end){
            return ;
        }
        int maxIdx = findMax(numbers, start, end);
        visited[maxIdx] = true;
        cnt += 1;

        if(maxIdx < end && cnt < n-k){
            rec(numbers, maxIdx + 1, end, n,k);
        }
        if(maxIdx > 0 && cnt < n-k){
            rec(numbers, start,maxIdx-1, n,k);
        }
    }

    public int findMax(String[] numbers, int start, int end){
        int MaxNum = -1;
        int maxIdx = 0;
        for(int i = start; i <= end ; i++){
            if(numbers[i].equals("9")){
                // System.out.println(numbers[i]);
                return i;
            }
            if(MaxNum < Integer.parseInt(numbers[i])){
                MaxNum = Integer.parseInt(numbers[i]);
                maxIdx = i;
            }
        }
        return maxIdx;
    }
    
    
}