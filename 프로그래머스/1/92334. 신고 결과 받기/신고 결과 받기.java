import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // Map<신고자, Set<당한사람>>
        // Map<당한사람, 횟수>
        // report를 순회하면서 신고자에 set이 있으면 확인해서 없을 때 추가
        // 순회 완료 후 map에서 k 이상인 것을 Set으로 다시 모아둠
        // 첫 번째 Map의 값과 합집합 사이즈를 저장
        Map<String, Set<String>> reportMap = new HashMap<>();
        Map<String, Integer> alarmCnt = new HashMap<>();
        
        for(int i = 0 ; i < id_list.length ; i++){
            reportMap.put(id_list[i], new HashSet<>());
        }
        for(int i = 0 ; i < report.length ; i++){
            String[] sl = report[i].split(" ");
            if(reportMap.get(sl[0]).contains(sl[1])){
               continue; 
            }
            
            reportMap.get(sl[0]).add(sl[1]);
            alarmCnt.put(sl[1], alarmCnt.getOrDefault(sl[1], 0) +1);
        }
        
        Set<String> alarmId = new HashSet<>();
        for(int i = 0 ; i < id_list.length ; i++){
            int cnt = alarmCnt.getOrDefault(id_list[i], 0);
            if(cnt >= k){
                alarmId.add(id_list[i]);
            }
        }
        for(int i = 0 ; i < id_list.length ; i++){
            Set<String> myReport = reportMap.get(id_list[i]);
            myReport.retainAll(alarmId);
            answer[i] = myReport.size();
        }
        return answer;
    }
}