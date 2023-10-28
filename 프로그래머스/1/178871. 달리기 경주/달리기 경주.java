import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> pm = new HashMap<>();
        Map<Integer, String> rm = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
          pm.put(players[i], i);
          rm.put(i, players[i]);
        }

        for(String calling : callings){
          Integer nowRank = pm.get(calling);

          String beforePlayer = rm.get(nowRank - 1);
          pm.put(beforePlayer, nowRank);
          pm.put(calling, nowRank - 1);

          rm.put(nowRank - 1, calling);
          rm.put(nowRank, beforePlayer);
        }

        pm.forEach((name, rank) -> {
          // System.out.println(name + " " + rank);
          answer[rank] = name;
        });

        return answer;
    }
}