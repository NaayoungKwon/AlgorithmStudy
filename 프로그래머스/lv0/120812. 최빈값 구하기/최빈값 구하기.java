import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int e : array){
            map.put(e, map.getOrDefault(e,0)+1);
        }
        int min_value = 0, min_idx = 0;
        boolean dup = false;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int v = entry.getValue();
            int key = entry.getKey();
            // System.out.println(key + " " + v + " " + dup);
            // System.out.println(key);
            if(min_value == v){
                dup = true;
            } else if (v > min_value){
                min_value = v;
                min_idx = key;
                dup = false;
            }
        }
        if(dup){
            return -1;
        }
        return min_idx;
    }
}