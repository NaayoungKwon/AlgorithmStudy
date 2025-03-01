class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] server_count = new int[24];

        for(int i = 0 ; i < 24; i ++){
            int need = players[i] / m;
            int more = need - server_count[i];
            if(more > 0){
                answer += more;
                for(int j = i ; j < Math.min(i + k, 24) ; j++){
                    server_count[j] += more;
                }
            }
        }
        return answer;
    }
}