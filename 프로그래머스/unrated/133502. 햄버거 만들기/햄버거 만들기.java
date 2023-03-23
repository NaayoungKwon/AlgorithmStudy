import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        for(int e : ingredient){
            st.add(e);
            if(isHamberger(st)){
                for(int i = 0 ; i < 4 ; i++){
                    st.pop();
                }
                answer += 1;
            }
            // 비었으면 무조건 넣는다.
            // 비어있지 않은 상태에서 빵이 들어왔으면 지금까지 쌓인걸 확인한다
            // 쌓인게 햄버거 모양이면 그 것 만큼 pop한다
            // 빵이 아닌 다른 것이면 그냥 쌓는다.
        }
        return answer;
    }

    public boolean isHamberger(Stack<Integer> st){
        int l = st.size();
        if( l >= 4 ){
            if(st.get(l-1) == 1 && st.get(l-2) == 3 && st.get(l-3) == 2 && st.get(l-4) == 1){
                return true;
            }
        }
        return false;
    }
}