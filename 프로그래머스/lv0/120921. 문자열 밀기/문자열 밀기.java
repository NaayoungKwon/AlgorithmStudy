import java.util.*;

class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        int aLen = A.length();
        if( aLen != B.length()){
            return -1;
        }
        StringBuilder strBuf = new StringBuilder(A);
        for(int i = 0 ; i < aLen ; i++){
            // System.out.println(strBuf.toString());
            if(B.equals(strBuf.toString())){
                return i;
            }
            char last = strBuf.charAt(aLen-1);
            strBuf.deleteCharAt(aLen-1);
            strBuf.insert(0,last);
        }
        return -1;
    }
}