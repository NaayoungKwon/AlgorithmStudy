import java.time.LocalTime;
import java.util.*;


class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int max_time = 0;
        String max_title = "(None)";

        String[] listened = m.split("(?=[A-Z]#?)");
        for(String musicInfo : musicinfos) {
            String[] split1 = musicInfo.split(",");
            Music music = new Music(LocalTime.of(Integer.parseInt(split1[0].split(":")[0]),
                Integer.parseInt(split1[0].split(":")[1])),
                LocalTime.of(Integer.parseInt(split1[1].split(":")[0]),
                    Integer.parseInt(split1[1].split(":")[1])),
                split1[2], split1[3]);

            List<String> melody = music.getMelody();
           // System.out.println(melody);

            // int j = 0, mlen = listened.length;
            boolean flag = false;
            for(int i = 0 ; i < melody.size() ; i++){
                if(flag){
                    break;
                }
                List<String> newMelody = melody.subList(i, melody.size());
                int j = 0, mlen = listened.length;
                for(String s : newMelody){
                    if(s.equals(listened[j])){
                        j++;

                        if(j == mlen){
                            int duration = music.getDuration();
                            if(duration > max_time){
                                max_time = duration;
                                max_title = music.title;
                            }
                            break;
                        }
                    } else {
                        j = 0;
                    }
   
                }
            }
        }

        return max_title;
    }

    public static class Music{
        LocalTime start;
        LocalTime end;
        String title;
        String[] music;
        int time;

        public Music(LocalTime start, LocalTime end, String title, String music) {
            this.start = start;
            this.end = end;
            this.title = title;
            this.music = music.split("(?=[A-Z]#?)");
            this.time = this.music.length;
        }

        public int getDuration() {
            return (int) (end.toSecondOfDay() - start.toSecondOfDay())/60;
        }

        public List<String> getMelody() {
            int duration = getDuration();
            int n = 0;
            if(duration < this.time){
                n = duration;
            } else {
                n = (int) (Math.ceil((double) getDuration()/this.time) * this.time);;
            }

            List<String > sb = new ArrayList<>();
            for(int i = 0 ; i < n ; i++){
                sb.add(this.music[(i%this.time)]);
            }
            return sb;
        }
    }
}