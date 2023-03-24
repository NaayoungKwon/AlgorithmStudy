import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        Student[] students = new Student[score.length];
        for(int i = 0 ; i < score.length ; i++){
            double mid = (double) (score[i][0] + score[i][1])/2;
            Student student = new Student(i, mid);
            students[i] = (student);
        }
        Arrays.sort(students);
        int l = 0, prevSameL = 1, nowSamleL = 0;
        double prevScore= 300;
        for(int i = 0 ; i < score.length ; i++){
            // System.out.println(students[i].midScore  + " " + prevScore + " " + l + " " + prevSameL);
            // l은 현재 값
            // prevSameL은 이전에 같은 등수가 얼마나 있었는지
            Student me = students[i];
            if(me.midScore < prevScore){
                l += prevSameL;
                prevScore = me.midScore;
                prevSameL = 1;
                answer[me.idx] = l;
            } else{
                answer[me.idx] = l;
                prevSameL += 1;
            }
        }
        return answer;
    }
    
    public class Student implements Comparable<Student>{
        int idx;
        double midScore;

        Student(int idx, double midScore){
            this.idx = idx;
            this.midScore = midScore;
        }

        public int compareTo(Student other){
            if(this.midScore > other.midScore){
                return -1;
            }
            return 1;
        }
    }
}