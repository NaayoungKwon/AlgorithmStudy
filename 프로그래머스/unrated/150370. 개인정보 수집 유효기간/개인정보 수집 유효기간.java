import java.util.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> dict = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < terms.length ; i++){
            String[] parse = terms[i].split(" ");
            dict.put(parse[0], Integer.parseInt(parse[1]));
        }

        for(int i = 0 ; i < privacies.length ; i++){
            String[] privacy = privacies[i].split(" ");
            if(compareDate(today, expiredDate(privacy[0], dict.get(privacy[1]) ))){
                result.add(i+1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public Calendar expiredDate(String day, Integer month){
        Calendar cal = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        Date date = null;
        try {
            date = df.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.setTime(date);
        cal.add(Calendar.MONTH, month);
        return cal;
    }

    public boolean compareDate(String today, Calendar compDay){
        int year = compDay.get(Calendar.YEAR);
        int month = compDay.get(Calendar.MONTH)+1;
        int day = compDay.get(Calendar.DATE);
        int[] todays = new int[3];
        String[] strTodays = today.split("\\.");
        for(int i = 0 ; i < 3 ; i++){
            todays[i] = Integer.parseInt(strTodays[i]);
        }

        if(year < todays[0]){
            return true;
        } else if (year == todays[0]){
            if(month < todays[1]){
                return true;
            } else if(month == todays[1]){
                if(day <= todays[2]){
                    return true;
                }
            }
        }
        return false;
    }
}