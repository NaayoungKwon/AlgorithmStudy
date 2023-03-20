import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        int l = survey.length;
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0 ; i < l ; i++){
            if(choices[i] < 4 ){
                String key = survey[i].split("")[0];
                int score = findScore(true, choices[i]);
                map.put(key, map.getOrDefault(key,0) + score);
            } else{
                String key = survey[i].split("")[1];
                int score = findScore(false, choices[i]);
                map.put(key, map.getOrDefault(key,0) + score);
            }
        }
        if(map.getOrDefault("R", 0 ) < map.getOrDefault("T",0)){
            answer.append("T");
        } else{ //abcdefghijklmnop qrstuvwxyz
            answer.append("R");
        }
        if(map.getOrDefault("C", 0 ) < map.getOrDefault("F",0)){
            answer.append("F");
        } else{ //abcdefghijklmnop qrstuvwxyz
            answer.append("C");
        }
        if(map.getOrDefault("J", 0 ) < map.getOrDefault("M",0)){
            answer.append("M");
        } else{ //abcdefghijklmnop qrstuvwxyz
            answer.append("J");
        }
        if(map.getOrDefault("A", 0 ) < map.getOrDefault("N",0)){
            answer.append("N");
        } else{ //abcdefghijklmnop qrstuvwxyz
            answer.append("A");
        }

        return answer.toString();
    }

    public int findScore(boolean left, int score){
        if(left){
            return (score == 1 ? 3 : (score == 2 ? 2 : 1));
        } else{
            return score - 4;
        }
    }
}