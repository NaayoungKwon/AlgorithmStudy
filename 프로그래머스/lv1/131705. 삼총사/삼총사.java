class Solution {
    int answer = 0;
    public int solution(int[] number) {
        int[] arr = new int[3];
        combination(arr, 0, number.length, 3, 0, number);
        return answer;
    }
    
    public void combination(int[] arr, int index, int n, int r, int target, int[] nums) {
        int s = -1;
        if (r == 0){
            s = arr[0] + arr[1] + arr[2];
            if (s == 0) {
                answer += 1;
            }
        }else if (target == n)
            return;
        else {
            arr[index] = nums[target];
            combination(arr, index + 1, n, r - 1, target + 1, nums);
            combination(arr, index, n, r, target + 1, nums);
        }
    }
}