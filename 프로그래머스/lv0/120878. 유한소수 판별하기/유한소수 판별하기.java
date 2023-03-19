class Solution {
    public int solution(int a, int b) {
         for(int i = a*b ; i > 1 ; i--){
            if(a%i == 0 && b%i == 0){
                a /= i;
                b /= i;
            }
        }
        // System.out.println(a + " "+b);
        while(b > 1){
            if(b % 2 == 0){
                b /= 2;
            } else if (b % 5 == 0) {
                b /= 5;
            } else{
                return 2;
            }
        }
        return 1;
    }
}