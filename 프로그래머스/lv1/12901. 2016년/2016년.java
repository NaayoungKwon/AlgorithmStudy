class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] weekend = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] endDay = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
        int total = 4;
        for(int i = 0 ; i < a-1 ; i++){
            total += endDay[i];
        }
        total += b;
        return weekend[total% 7];
    }
}