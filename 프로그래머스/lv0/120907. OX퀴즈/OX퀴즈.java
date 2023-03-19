class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        int i = 0;
        for(String q : quiz){
            String[] qList = q.split(" ");
            int result = 0;
            int expected = 0;
            String prev = null;
            for(String c : qList){
                if(c.equals("-") || c.equals("=") || c.equals("+")){
                    prev = c;
                } else{
                    int cInt = Integer.parseInt(c);
                    if(prev == null){
                        result = cInt;
                    } else if (prev.equals("+")){
                        result += cInt;
                    } else if (prev.equals("-")){
                        result -= cInt;
                    } else if (prev.equals("=")){
                        if(result == cInt){
                            answer[i] = "O";
                        } else{
                            answer[i] = "X";
                        }
                    }
                }
            }
            i += 1;
        }
        return answer;
    }
}