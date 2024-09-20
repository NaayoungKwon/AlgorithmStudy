import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] canSpeak = {"aya", "ye", "woo", "ma"};
        
        for(int i = 0 ; i < babbling.length ; i++){
            String bab = babbling[i];
            int j = 0;
            String before = "";
            while (j+2 <= bab.length()){
                // canSpeak에서 하나 씩 확인 + before와 비교
                boolean flag = false;
                for(int k = 0 ; k < 4; k++){
                    if(bab.substring(j).startsWith(canSpeak[k]) && !canSpeak[k].equals(before)){
                        j += canSpeak[k].length();
                        before = canSpeak[k];
                        flag = true;
                    }
                }
                // 맞으면 j += & before에 누적
                // 다 해봤는데 없으면 break
                if(flag == false){
                    break;
                }
                
            }
            if(j == bab.length()){
                answer += 1;
            }
            
        }
        return answer;
    }
}