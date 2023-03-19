class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        for(String[] row : db){
            if(row[0].equals(id_pw[0])){
                if(row[1].equals(id_pw[1])){
                    return "login";
                }
                return "wrong pw";
            }
        }
        return "fail";
    }
}