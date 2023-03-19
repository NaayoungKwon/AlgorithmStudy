class Solution {
    public String solution(String polynomial) {
        StringBuilder answer = new StringBuilder();
        String[] nums = polynomial.split(" ");
        int x = 0;
        int nonX = 0;
        
        for(String num : nums){
            if(num.contains("x")){
                if(num.equals("x")){
                    x += 1;
                }else {
                    x += Integer.parseInt(num.replace("x",""));
                }
            } else if(num.contains("+")){
                continue;
            }else{
                nonX += Integer.parseInt(num);
            }
        }
        if(x > 0){
            if(x > 1){
                answer.append(x);
            }
            answer.append("x");
        } 
        if(nonX > 0){
            if(answer.length() > 0){
                answer.append(" + ");
            }
            answer.append(nonX);
        }
        return answer.toString();
    }
}