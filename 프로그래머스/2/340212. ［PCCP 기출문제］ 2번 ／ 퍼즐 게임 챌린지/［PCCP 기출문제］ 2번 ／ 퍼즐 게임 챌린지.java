import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100000;
        int left = 1, right = 100001;

        while(left <= right){
            int mid = (left + right) / 2;
            long this_time = calculateLimit(diffs, times, mid);
            // 레벨이 높다 : 시간이 적게 걸린다 -> limit 안이다 -> 레벨 더 낮춰봐도 된다
            // 레벨이 낮음 -> 시간이 많이 걸림 -> limit을 넘었다 -> 레벨을 높여라
            // System.out.println("mid : " + mid + ", this_time : " + this_time);
            if(this_time <= limit){
                answer = Math.min(answer, mid);
                right = mid-1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    public long calculateLimit(int[] diffs, int[] times, int level){
        long time_sum = 0;
        int time_prev = 0;
        int n = diffs.length;
        for(int i = 0 ; i < n ; i++){
            int repeat_time = (Math.max(0, diffs[i] - level) * (time_prev + times[i]));
            time_sum += (repeat_time + times[i]);
            time_prev = times[i];
        }
        return time_sum;
    }
}