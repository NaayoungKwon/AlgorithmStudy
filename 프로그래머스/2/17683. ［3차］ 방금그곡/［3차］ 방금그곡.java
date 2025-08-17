import java.time.LocalTime;
import java.time.Duration;
import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        String[] nm = m.split("(?=[A-Z]#?)");
        PriorityQueue<Music> pq = new PriorityQueue<>(Music::compareTo);
        for(int i = 0 ; i < musicinfos.length ; i++){
            Music music = new Music(i, musicinfos[i]);
            if(music.contains(m, nm) ){
                pq.add(music);
            }
        }

        if(pq.isEmpty()){
            return "(None)";
        }
        return pq.poll().name;
    }
    
    public static class Music{
        int index;
        int playTime;
        LocalTime startTime;
        String name;
        String[] melody;

        Music(int index,String full){
            this.index = index;
            String[] split = full.split(",");
            this.startTime = LocalTime.parse(split[0]);
            LocalTime endTime = LocalTime.parse(split[1]);
            this.playTime = (int) (endTime.toSecondOfDay() - startTime.toSecondOfDay())/60;       
            this.name = split[2];
            this.melody = new String[playTime];
            String[] temp = split[3].split("(?=[A-Z]#?)");
            for(int i = 0; i < playTime; i++){
                int ii = (i + temp.length) % temp.length;
                this.melody[i] = temp[ii];
            }
        }

        public int compareTo(Music other) {
            if(this.playTime == other.playTime) {
                return this.index - other.index;
            }
            return -(this.playTime - other.playTime);
        }

        public boolean contains(String m, String[] nm){
            for(int i = 0 ; i <= this.melody.length - nm.length; i++){
                if(this.melody[i].equals(nm[0])){
                    StringBuilder sb = new StringBuilder();
                    for(int j = i ; j < i +  nm.length ; j++){
                        sb.append(this.melody[j]);
                    }
                    if(m.equals(sb.toString())){
                        return true;
                    }
                }
            }
            return false;
        }

    }
}