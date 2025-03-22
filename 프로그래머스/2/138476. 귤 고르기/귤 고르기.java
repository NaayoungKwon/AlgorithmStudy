import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            int cnt = map.getOrDefault(t, 0);
            map.put(t, cnt + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int key : map.keySet()){
            pq.add(new int[]{key, map.get(key)});
        }
        k = tangerine.length - k;
        while(k > 0){
            int[] t = pq.poll();
//            System.out.println("t : " + t[0] + ", cnt : " + t[1]);
            k -= t[1];
            if(k < 0){
                pq.add(t);
            }
        }
        return pq.size();
    }
}