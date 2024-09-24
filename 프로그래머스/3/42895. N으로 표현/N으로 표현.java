import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        if(N == number){
            return 1;
        }
        
        Map<Integer,Set<Integer>> dp = new HashMap<>();
        Set<Integer> history = new HashSet<>();
        
        dp.put(1, Set.of(N, -N));

        
        history.add(N);
        history.add(-N);
        history.add(-1);
        history.add(1);
        history.add(-2*N);
        history.add(2*N);

        history.add(-(N*10 + N));
        history.add(N*10 + N);
        
        if(Math.sqrt(Integer.MAX_VALUE) < N) {
            dp.put(2, Set.of(1, -1, -(2*N), 2*N, -(N*10+N), N*10+N));
        } else {
            history.add(-N*N);
            history.add(N*N);
            dp.put(2, Set.of(1, -1, -(2*N), 2*N, -(N*10+N), N*10+N));
        }
        
        if(history.contains(number)){
            return 2;
        }
        
        
        for(int i = 3 ; i <= 8 ; i++){
            Set<Integer> sGroup = new HashSet<>();
            int c = N;
            for(int j = 1 ; j < i ; j++){
                c = (c*10 + N);
            }
            sGroup.add(c);
            sGroup.add(-c);
            
            for(int j = 1 ; j <= i/2 ; j++){
 
                Integer[] jSet = dp.getOrDefault(j, new HashSet<>()).toArray(new Integer[0]);
                Integer[] iSet = dp.getOrDefault(i-j, new HashSet<>()).toArray(new Integer[0]);
                for(int a = 0 ; a < jSet.length ; a++){
                    for(int b = 0 ; b < iSet.length; b++){
                        int[] rl = new int[6];
                        rl[0] = jSet[a] - iSet[b];
                        rl[1] = jSet[a] + iSet[b];
                        rl[2] = jSet[a] * iSet[b];
                        rl[3] = iSet[b] != 0 ? jSet[a] / iSet[b] : 0;
                        rl[4] = jSet[a] != 0 ? iSet[b] / jSet[a] : 0;
                        rl[5] = iSet[b] - jSet[a];
                        if(number == rl[0] || number == rl[1] || number == rl[2] || number == rl[3] || number == rl[4] || number == rl[5]){
                            return i;
                        }
                        
                        for(int x = 0; x < 6 ; x++){
                            if(rl[x] != 0 && !history.contains(rl[x])){
                                history.add(rl[x]);
                                sGroup.add(rl[x]);
                                // System.out.println(i + ": " + jSet[a] +" "+ iSet[b] + " " +i +" "+ rl[x]);
                            } 
                        }
                    }
                }
            }
            dp.put(i, sGroup);
        }
        
        return -1;
    }
}