class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        String re = "[^" + skill + "]";
        for(int i = 0 ; i < skill_trees.length; i++){
            String my = skill_trees[i].replaceAll(re, "");
            for(int j = skill.length(); j > 0 ; j--){
                String s = skill.substring(0, j);
                my = my.replaceAll(s,"");
            }
            if(my.length() == 0){
                answer+=1;
            }
            
        }
        return answer;
    }
}