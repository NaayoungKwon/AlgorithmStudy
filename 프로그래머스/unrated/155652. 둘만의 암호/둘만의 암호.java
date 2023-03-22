class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        for(String c : s.split("")){
            // c에서 1 ~ index까지 더해가면서 나온 String을 확인한다.
            // 각 String이 skip에 포함되어있는지 확인한다.
            // 포함되어 있으면 cnt를 올리지 않고 i만 올린다
            // 포함되지 않으면 cnt, i 둘 다 올린다.
            int i = 1, cnt = 0;
            char nextChar = (char)(c.charAt(0));
            while(true){
                if(nextChar == 'z'){
                    nextChar = 'a';
                } else{
                    nextChar += 1;
                }
                String next = String.valueOf(nextChar);
                if(skip.contains(next) == false){
                    cnt += 1;
                }
                if(cnt == index){
                    break;
                }
                
            }
            answer.append(String.valueOf(nextChar));
        }
        return answer.toString();
    }
}