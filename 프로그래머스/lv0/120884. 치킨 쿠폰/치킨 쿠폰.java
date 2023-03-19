class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while(chicken > 9){
            int coupon = (int)(chicken/10);
            answer += coupon;
            chicken -= (coupon*10);
            chicken += coupon;
        }
        return answer;
    }
}