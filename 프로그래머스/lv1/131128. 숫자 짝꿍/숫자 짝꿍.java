import java.util.*;
import java.util.stream.Stream;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        HashMap<String, Integer> xMap = new HashMap<>();
        HashMap<String, Integer> yMap = new HashMap<>();
        for(String xc : X.split("")){
            xMap.put(xc, xMap.getOrDefault(xc, 0) + 1);
        }
        for(String yc : Y.split("")){
            yMap.put(yc, yMap.getOrDefault(yc, 0) + 1);
        }
        List<String> keys = new ArrayList<>();
        for(String k : xMap.keySet()){
            keys.add(k);
        }
        keys.sort(Comparator.reverseOrder());
        for(String xc : keys){
            // if(answer.length() == 0 && xc.equals("0")){
            //     continue;
            // }
            if(yMap.containsKey(xc)){
                int num = (Math.min(yMap.get(xc) , xMap.get(xc)));
                answer.append(xc.repeat(num));
            }
        }
        if(answer.length() == 0){
            return "-1";
        }
        while(answer.length() > 1  && answer.charAt(0) == '0'){
            answer.deleteCharAt(0);
        }
        return answer.toString();
    }
}