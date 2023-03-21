class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        boolean[] visited = new boolean[n];
        int idx = 1, start = section[0];
        // start는 section[0]으로 둔다. start + m 만큼할게 적을 때 까지 반복문을 돈다.
        // section[i] + m < section[i+1] 이 되면 asnwer += 1;
        while(idx < section.length){
            if(start + m <=  section[idx]){
                answer += 1;
                start = section[idx];
            }
            idx += 1;
        }
        return answer;
    }
}