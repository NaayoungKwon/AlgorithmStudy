import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        int n = phone_book.length;
        for(int i = 0 ; i < n-1 ; i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                    return false;
            }
        }
        return true;
    }
}