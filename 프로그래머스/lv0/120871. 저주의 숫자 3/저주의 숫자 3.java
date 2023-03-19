class Solution {
    public int solution(int n) {
        int c = 0;
        for(int i = 1 ; i <= n ; i++){
            int a = i;
            c += 1;
            while(validate(c) == false){
                c += 1;
            }
        }
        return c;
    }
    
    public boolean validate(int k){
        if(k % 3 == 0 || k%10==3 || (k > 9 && ((int)(k/10) == 3)) || (k>100 && (int)((k/10)%10)== 3)){
            return false;
        }
        return true;
    }
}