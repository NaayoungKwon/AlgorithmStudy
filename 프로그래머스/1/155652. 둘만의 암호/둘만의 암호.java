import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        String reg = "[" + skip +"]";
        String alpha = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".replaceAll(reg,"");
        
        // s를 순회한다
        // alpha에서 자기 위치인 값을 찾는다.
        // 거기서 부터 skip에 있는 것들은 substr로 없애버려
        // 그다음 index 만큼 더했을 때 어딧는지 확인
        for(int i = 0 ; i < s.length(); i++){
            int idx = alpha.indexOf(s.charAt(i)) + index;
            String sub = alpha.substring(idx); //.replaceAll(reg,"");
            // sub = sub.replaceAll(reg,"");
            sb.append(alpha.charAt(idx));
        }
        return sb.toString();
    }
}