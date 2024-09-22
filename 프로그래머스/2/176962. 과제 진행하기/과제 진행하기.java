import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        // 멈춘 과제는 스택에
        Arrays.sort(plans, (String[] p1, String[] p2) -> {
            String[] p1s = p1[1].split(":");
            String[] p2s = p2[1].split(":");
            if(Integer.parseInt(p1s[0]) < Integer.parseInt(p2s[0])){
                return -1;
            } else if (Integer.parseInt(p1s[0]) > Integer.parseInt(p2s[0])){
                return 1;
            } else if (Integer.parseInt(p1s[1]) < Integer.parseInt(p2s[1])){
                return -1;
            }
            return 1;
        });
        
        Stack<Plan> lefts = new Stack<>();
        Plan before = new Plan(plans[0]);
        int k = 0;
        for(int i = 1 ; i < plans.length ; i++){
            Plan newPlan = new Plan(plans[i]);
            // System.out.println(newPlan.name);
            int[] end = before.endTime();
            // System.out.println("end " + end[0] + " " + end[1]);
            // end가 newPlan보다 앞이면 result에 before 넣고 + stack에 있는거 처리 반복 + new를 before로 업뎃
            if(end[0] < newPlan.hh || (end[0] == newPlan.hh && end[1] <= newPlan.mm)){
                answer[k] = before.name;
                k += 1;
                int leftMin = (newPlan.hh - end[0] ) * 60 + (newPlan.mm - end[1]);
                while(lefts.size() > 0 && leftMin > 0){
                    Plan leftPlan = lefts.pop();
                    int leftPlanTime = leftMin - leftPlan.left;
                    // System.out.println("left " + leftMin);
                    if(leftMin >= leftPlan.left){
                        answer[k] = leftPlan.name;
                        k += 1;
                        leftMin -= leftPlan.left;
                        // System.out.println("add result to " + leftPlan.name);
                    } else {
                        leftPlan.updateLeft(leftPlan.left - leftMin);
                        leftMin = 0;
                        lefts.add(new Plan(leftPlan));
                        // System.out.println("remian " + leftPlan.name);
                    }
                }
                before = newPlan;
                // System.out.println("add result");
            } else { // end가 newPlan보다 뒤면 stack에 before넣고 + new를 before로 업뎃
                int leftMin = (newPlan.hh - end[0] ) * 60 + (newPlan.mm - end[1]);
                before.updateLeft(-leftMin);
                // System.out.println("add st left " +leftMin );
                lefts.add(new Plan(before));
                before = newPlan;
                // System.out.println("add st");
            }
        }
        lefts.add(before);
        while(lefts.size() > 0 ){
            answer[k] = lefts.pop().name;
            k += 1;
        }
        
        return answer;
    }
    
    
    public static class Plan {
        String name;
        int hh;
        int mm;
        int left;
        
        Plan(String[] p){
            this.name = p[0];
            this.hh = Integer.parseInt(p[1].split(":")[0]);
            this.mm = Integer.parseInt(p[1].split(":")[1]);
            this.left = Integer.parseInt(p[2]);
        }
        Plan(Plan p){
            this.name = p.name;
            this.hh = p.hh;
            this.mm = p.mm;
            this.left = p.left;
        }
        
        public int[] endTime(){
            int k = mm + left;
            int nh = hh + (int)(k / 60);
            int nm = (k % 60);
            int[] r = {nh, nm};
            return r;
        }
        
        public void updateLeft(int left){
            this.left = left;
        }
        
    }
}