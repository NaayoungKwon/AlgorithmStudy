class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0 , idx2 = 0;
        int l1 = cards1.length, l2 = cards2.length;
        // goal의 길이만큼 순회하면서 확인한다
        // 카드 1의 제일 앞과 확인해보고
        // 카드 2와도 확인 해보고
        for(int i = 0 ; i < goal.length ; i++){
            if(idx1 < l1 && goal[i].equals(cards1[idx1])){
                idx1 += 1;
                continue;
            } else if (idx2 < l2 && goal[i].equals(cards2[idx2])){
                idx2 += 1;
                continue;
            } else{
                return "No";
            }
        }
        return "Yes";
    }
}