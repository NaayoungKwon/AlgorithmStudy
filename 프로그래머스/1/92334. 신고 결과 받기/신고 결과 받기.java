import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> nameIdx = new HashMap<>();

        for(String repo : report){
          String[] splitted = repo.split(" ");
          String reporter = splitted[0];
          String reported = splitted[1];

          if(reportMap.containsKey(reported)) {
            reportMap.get(reported).add(reporter);
          } else{
            HashSet<String> newSet = new HashSet<>();
            newSet.add(reporter);
            reportMap.put(reported,newSet );
          }
        }

        for(int i = 0; i < id_list.length; i++){
          nameIdx.put(id_list[i], i);
          answer[i] = 0;
        }
        
        reportMap.forEach((reported, reporters) -> {
          if(reporters.size() >= k){
            reporters.forEach(reporter -> {
              answer[nameIdx.get(reporter)]++;
            });
          }
        });

        return answer;
    }
}