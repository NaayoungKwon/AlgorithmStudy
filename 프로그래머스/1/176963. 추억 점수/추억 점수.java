import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> nameToScore = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
          nameToScore.put(name[i], yearning[i]);
        }

        for(int i = 0 ; i < photo.length ; i++){
          answer[i] = 0;
          for(int j = 0 ; j < photo[i].length ; j++){
            if(nameToScore.containsKey(photo[i][j])){
              answer[i] += nameToScore.get(photo[i][j]);
            }
          }
        }

        return answer;
    }
}