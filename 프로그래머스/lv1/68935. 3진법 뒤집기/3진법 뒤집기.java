class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder threeStr = new StringBuilder();
        while(n > 0){
            int m = n%3;
            threeStr.insert(0,m);
            n /= 3;
        }
//        threeStr.reverse();
//        int reverseThreeInt = Integer.parseInt(threeStr.toString());
        int i = 1;
        while( threeStr.length() > 0){
            answer += (i * (threeStr.charAt(0)-48));
            threeStr.deleteCharAt(0);
            i *= 3;
        }
        return answer;
    }
}