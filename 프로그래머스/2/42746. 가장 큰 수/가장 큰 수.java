import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        List<String> list = Arrays.stream(numbers).boxed().map(String::valueOf).map(s -> s.repeat(3))
          .sorted(Comparator.reverseOrder())
            .collect(Collectors.toUnmodifiableList());
        
        for(String i : list){
    //      String s = String.valueOf(i);
          answer.append(Integer.valueOf(i.substring(0, i.length() / 3)));
        }
        String r = answer.toString();
        if(r.matches("0+")){
          return "0";
        }
        return r;
    }
}