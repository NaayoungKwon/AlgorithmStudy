import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> st= new Stack<>();
        int ori = k;
        
        for(int i = 0; i <number.length(); i++){
            Integer c = Integer.parseInt(number.substring(i,i+1));
            while(k > 0 && st.size() > 0 && st.peek() < c){
                st.pop();
                k -= 1;
            }
            st.push(c);
        }
        while(st.size() > 0){
            int c = st.pop();
            answer.insert(0,c);
        }
        
        return answer.toString().substring(0, number.length() - ori);
    }
}