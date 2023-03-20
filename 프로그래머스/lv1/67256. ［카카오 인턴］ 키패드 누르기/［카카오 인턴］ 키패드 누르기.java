import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] leftPad = new int[]{1,4,7};
        int[] rightPad = new int[]{3,6,9};
        int leftH = 4, rightH = 4;
        HashMap<Integer,Integer> h = new HashMap<>();
        h.put(2,1);
        h.put(5,2);
        h.put(8,3);
        h.put(0,4);
        // number를 순회한다.
        for(int i = 0 ; i < numbers.length ; i++){
            int num = numbers[i];
            for(int j = 0 ; j < 3 ; j++) {
                if (leftPad[j] == num) {
                    answer.append("L");
                    leftH = j+1;
                    break;
                } else if (rightPad[j] == num) {
                    answer.append("R");
                    rightH = j+1;
                    break;
                }
            }
            if(answer.length() <= i) {
                int midH = h.get(num);
                int diffL = (leftH < 0 ? Math.abs(midH + leftH ) : Math.abs(midH - leftH) + 1);
                int diffR = (rightH < 0 ? Math.abs(midH + rightH ) : Math.abs(midH - rightH) + 1);
                String a = (diffL < diffR ? "L" : (diffR == diffL ? (hand.equals("left") ? "L" : "R") : "R"));
                answer.append(a);
                if (a.equals("L")) {
                    leftH = -midH;
                } else {
                    rightH = -midH;
                }
            }
           // System.out.println(num + " " + answer + " " + leftH + " " + rightH);
        }
        // 1,4,7이면 왼쪽, 369면 오른쪽을 누른다.
        // 왼 오 각자 자신의 높이를 업데이트 한다.
        // 2,5,8,0이 나오면 높이를 비교한다.

        return answer.toString();
    }
}