import java.util.*;
import java.util.stream.Collectors;

class Solution {
    
    static List<Set<Integer>> combinationList = new ArrayList<>();
    
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        combination(new int[n], 0, n, 5, 0);
        List<Set<Integer>> qList = new ArrayList<>();
          for (int[] ints : q) {
            Set<Integer> ls = Arrays.stream(ints).boxed().collect(Collectors.toSet());
            qList.add(ls);
          }

        for(Set<Integer> comb : combinationList){
            boolean flag = true;
//            System.out.println(comb);
            for(int i = 0 ; i < q.length ; i++){
                int count = 0;
                for (Integer element : comb) {
                    if (qList.get(i).contains(element)) {
                        count++;
                    }
                }
                if(count != ans[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                answer++;
            }

        }
        return answer;
    }
    
    public void combination(int[] arr, int index, int n, int r, int target) {
    if (r == 0){
        Set<Integer> ls = Arrays.stream(arr).boxed().collect(Collectors.toSet());
        combinationList.add(ls);
    } else if (target == n){
        return;
    } else {
        arr[index] = target+1;
        combination(arr, index + 1, n, r - 1, target + 1);
        combination(arr, index, n, r, target + 1);
    }
    }
}