class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] can = new String[]{ "aya", "ye", "woo", "ma" };
        for(String bab : babbling){
            for(int i = 0 ; i < 4 ; i++){
                bab= bab.replaceAll(can[i], ""+i );
            }
            // System.out.println(bab + bab.matches("[a-z]+"));
            if(bab.matches("^[0-4]*$") == false){
                continue;
            } else{
                String[] babs = bab.split("");
                boolean flag = true;
                for(int i = 0 ; i < babs.length-1 ; i++){
                    if(babs[i].equals(babs[i+1])){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    answer += 1;
                }
            }
        }
        return answer;
    }
}