import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files).map(File::new).sorted(File::compareTo).map(File::getFullName).toArray(String[]::new);
    }
    
        public static class File {

        String fullName;
        String head;
        Integer number;
        String tail;

        File(String fullName){
            Pattern pattern = Pattern.compile("([a-zA-Z]+[a-zA-Z .-]*)([0-9]{1,5})(.*)");
            Matcher matcher = pattern.matcher(fullName);
            matcher.find();
            this.head = matcher.group(1).toLowerCase();
            this.number = Integer.parseInt(matcher.group(2));
            this.tail = matcher.group(3);
            this.fullName = fullName;
        }

        public Integer compareTo(File other){
            if(this.head.equals(other.head)){
                return this.number.compareTo(other.number);
            } else {
                return this.head.compareTo(other.head);
            }
        }

        public String getFullName(){
            return this.fullName;
        }
    }
}