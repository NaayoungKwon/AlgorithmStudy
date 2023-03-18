class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        
        int den = 1;
        for(int i = 2 ; i <= Math.min(denom1,denom2) ; i++){
            if(denom1 % i == 0 && denom2 % i == 0){
                den *= i;
                denom1 /= i;
                denom2 /= i;
            }
        }
        // System.out.println(den);
        den = den * denom1 * denom2;
        int num = (numer1 * denom2) + (numer2 * denom1);
        // System.out.println(num);
        int u = 1;
        for(int i = 2; i <= Math.min(num,den) ; i++){
            if(num % i == 0 && den % i == 0){
                u = i;
            }
        }
        int[] answer = {num/u, den/u};
        return answer;
    }
}