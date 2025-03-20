import java.time.LocalTime;
import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];

        PriorityQueue<Homework> pq = new PriorityQueue<>(Homework::compareTo);
        for(String[] plan : plans){
            pq.add(new Homework(plan));
        }

        int cnt = 0;
        LocalTime now = pq.peek().start;
        Stack<Homework> left = new Stack<>();
        while(!pq.isEmpty()){
            Homework hw = pq.poll();

            // 만약 지금 시간이 숙제 시작시간이 되지 않았다면, 이전에 못한 숙제를 한다.
            // 숙제시작시간 - 지금시간 >= 남은숙제left : answer에 남은숙제과목 추가
            // 숙제시작시간 - 지금시간 < 남은숙제left : 남은숙제를 지금까지 얼마나했나 업데이트해서 스택에 다시 넣음
            while(!left.isEmpty() && now.isBefore(hw.start)){
                Homework leftHw = left.pop();
                LocalTime leftTime = hw.start.minusHours(now.getHour()).minusMinutes(now.getMinute());
                int studyTime = leftTime.getHour() * 60 + leftTime.getMinute();
                int realStudyTime = studyTime >= leftHw.left ? leftHw.left : studyTime;
                leftHw.did(realStudyTime);
                if(leftHw.isDone()){
                    answer[cnt] = leftHw.course;
                    cnt++;
                    
                } else {
                    left.add(leftHw);
                    // now = now.plusMinutes(studyTime);
                }
                now = now.plusMinutes(realStudyTime);
                
            }

            now = hw.start;

            // 다음 숙제를 흘끔 쳐다보고 현재 숙제를 얼마나 풀수 있는지 시간 계산을 한다.
            LocalTime studyTime = (pq.isEmpty() ? LocalTime.of(23,0) : pq.peek().start.minusHours(now.getHour()).minusMinutes(now.getMinute()));
            // 다음숙제시작시간 - 지금시간 >= 지금숙제 걸리는 시간 : answer에 지금숙제과목 추가
            if(studyTime.getHour()*60 + studyTime.getMinute() >= hw.left){
                answer[cnt] = hw.course;
                cnt ++;
                now = hw.start.plusMinutes(hw.left);
            } else {
                hw.did(studyTime.getHour() *60 + studyTime.getMinute());
                left.add(hw);
                now = now.plusHours(studyTime.getHour()).plusMinutes(studyTime.getMinute());
            }
            // 다음숙제시작시간 - 지금시간 < 지금숙제 걸리는 시간 : 현재숙제를 얼마나 했는지 업데이트해서 스택에 넣는다.

            // 현재 시간 업데이트
        }

        // stack에 남은 숙제들을 하나 씩 꺼내서 answer에 추가
        while(!left.isEmpty()){
            Homework leftHw = left.pop();
            answer[cnt] = leftHw.course;
            cnt++;
        }

        return answer;
    }
    
    public static class Homework{
        String course;
        LocalTime start;
        int playtime;
        int left;

        public Homework(String[] plan){
            this.course = plan[0];
            this.start = LocalTime.of(Integer.valueOf(plan[1].split(":")[0]), Integer.valueOf(plan[1].split(":")[1]));
            this.playtime = Integer.valueOf(plan[2]);
            this.left = this.playtime;
        }

        public void did(int studyTime){
            this.left -= studyTime;
        }

        public boolean isDone(){
            return this.left <= 0;
        }

        public int compareTo(Homework h){
            return this.start.compareTo(h.start);
        }

    }
}