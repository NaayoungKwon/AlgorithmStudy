class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int i = 0 ; i <= d/k ; i++){
            double d2 = Math.pow(d, 2);
            double ik2 = Math.pow(i * k, 2);
            double sqrt = Math.sqrt(d2 - ik2);
            long a = (long) (sqrt / k) + 1;
//            long a = ((long) Math.sqrt((d*d) - (i*i*k*k)) / k) + 1;
            // System.out.println(i + " : " + a);
            answer += a;
        }
        return answer;
    }
}