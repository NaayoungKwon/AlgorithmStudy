class Solution {
    public String solution(String new_id) {
        String answer = "";
        new_id = new_id.toLowerCase()
                        .replaceAll("[^a-z0-9-_.]","")
                        .replaceAll("[.]+",".")
                        .replaceAll("(^[.])|([.]$)","");
        if(new_id.length()== 0){
            new_id = "a";
        }
        if(new_id.length() >= 16){
            return new_id.substring(0,15).replaceAll("[.]$","");
        } else if (new_id.length() <= 2){
            int n = new_id.length();
            return new_id + new_id.substring(n-1,n).repeat(3-n);
        }
        
        // System.out.println(new_id);
        return new_id;
    }
}