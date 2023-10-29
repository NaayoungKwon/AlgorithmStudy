import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        int idx = 0;
        Map <String, Integer> termsMap = new HashMap<>();
        for(String term : terms){
          String[] termArr = term.split(" ");
          termsMap.put(termArr[0], Integer.parseInt(termArr[1]));
        }

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        List<LocalDate> days = new ArrayList<>();
        for(String privacy : privacies){
          String[] privacyArr = privacy.split(" ");

          LocalDate date = LocalDate.parse(privacyArr[0], df).plusMonths(termsMap.get(privacyArr[1]));
          if(date.getDayOfMonth() == 1){
            date = date.minusMonths(1).plusDays(27);
          } else{
            date = date.minusDays(1);
          }
          days.add(date);
        }

        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < days.size() ; i++){
          if(days.get(i).isBefore(LocalDate.parse(today, df))){
            arr.add(i+1);
          }
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}