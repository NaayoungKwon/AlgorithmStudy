import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        List<File> fileList = new ArrayList<>();

        Pattern pattern = Pattern.compile("([a-zA-Z]+[a-zA-Z .-]*)([0-9]{1,5})(.*)");
        for(int i = 0 ; i < files.length ; i++){
            String file = files[i];
            Matcher matcher = pattern.matcher(file);
            matcher.find();
            String head = matcher.group(1);
            String number = matcher.group(2);
            String tail = matcher.group(3);
            fileList.add(new File(head, number, tail, i));
        }
        fileList.sort(File::compareTo);

        return fileList.stream().map(File::toString).toArray(String[]::new);
    }

    public static class File implements Comparable<File>{
        String head;
        String numberStr;
        Integer number;
        String tail;
        Integer idx;

        public File(String head, String numberStr, String tail, Integer idx){
            this.head = head;
            this.numberStr = numberStr;
            this.number = Integer.valueOf(numberStr);
            this.tail = tail;
            this.idx = idx;
        }


        @Override
        public int compareTo(File o) {
            int i = this.head.toLowerCase().compareTo(o.head.toLowerCase());
            if(i != 0){
                return i;
            } else if (!Objects.equals(this.number, o.number)){
                return this.number - o.number;
            }
            return this.idx.compareTo(o.idx);
        }

        public String toString(){
            return head + numberStr + tail;
        }
    }
}