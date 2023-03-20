class Solution {
    int answer = 0;
    public int solution(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        comb(nums, visited, 0 , n , 3);
        return this.answer;
    }

    public void comb(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            boolean flag = isPrime(arr, visited);
            // System.out.println(flag);
            if(flag){
                this.answer += 1;
            }
            return;
        }

        if (depth == n) {
            return;
        }

        visited[depth] = true;
        comb(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        comb(arr, visited, depth + 1, n, r);
    }

    public boolean isPrime(int[] arr, boolean[] visited){
        int sum = 0;
        for(int i = 0 ; i < visited.length ; i++){
            if(visited[i]){
                sum += arr[i];
            }
        }
        // System.out.println(sum);
        for(int i = sum-1 ; i > 1 ; i--){
            if(sum % i == 0){
                return false;
            }
        }
        return true;
    }
}