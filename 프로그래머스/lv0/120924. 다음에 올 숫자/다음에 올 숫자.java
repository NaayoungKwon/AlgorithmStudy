class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int add = common[1] - common[0];
        boolean flag = true;
        for(int i = 2 ; i < common.length ; i++){
            if(common[i] - common[i-1] != add){
                flag = false;
                break;
            }
        }
        if(flag){
            return common[common.length-1] + add;
        }
        flag = true;
        int mul = common[1] / common[0];
        for(int i = 2 ; i < common.length ; i++){
            if(common[i] / common[i-1] != mul){
                flag = false;
                break;
            }
        }
        return common[common.length-1] * mul;
    }
}