
import java.util.*;
class Solution {
    int answer  =0;
    HashSet<Integer> hs = new HashSet<Integer>();
    public int solution(String numbers) {
        // 배열로 만든다
        // nP1 ~ nPn 까지 순회하면서 prime인지 확인한다
        int[] arr = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        for(int i = 1 ; i <= arr.length ; i++){
            permutation(arr, 0, arr.length, i);
        }
        return answer;
    }

    void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < r ; i++){
                sb.append(arr[i]);
            }
            int num = Integer.parseInt(sb.toString());
            
            if(hs.contains(num) == false&& isPrime(num)){ 
                // System.out.println(num);
                answer += 1;
            }
            hs.add(num);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    boolean isPrime(int number){
        if(number < 2){
            return false;
        }
        boolean flag = true;
        for(int i = 2 ; i <= Math.sqrt(number) ; i++){
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }
}