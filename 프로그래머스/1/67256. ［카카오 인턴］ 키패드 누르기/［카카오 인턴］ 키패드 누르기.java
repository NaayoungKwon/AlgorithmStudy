import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Node l = new Node(3,0), r = new Node(3,2);
        for(int i = 0 ; i < numbers.length ; i++){
            int number = numbers[i];
            if(isLeft(number)){
                sb.append("L");
                l = new Node(number);
            } else if (isRight(number)){
                sb.append("R");
                r = new Node(number);
            } else {
                Node new_n = new Node(number);
                int l_d = l.dist(new_n);
                int r_d = r.dist(new_n);
                if(l_d < r_d){
                    sb.append("L");
                    l = new_n;
                } else if (l_d > r_d){
                    sb.append("R");
                    r = new_n;
                } else if (hand.equals("left")){
                    sb.append("L");
                    l = new_n;
                } else {
                    sb.append("R");
                    r = new_n;
                }
            }
        }
        return sb.toString();
    }
    
    public boolean isLeft(int num){
        switch(num){
            case 1:
            case 4:
            case 7:
                return true;
            default:
                return false;
        }
    }
    
    public boolean isRight(int num){
        switch(num){
            case 3:
            case 6:
            case 9:
                return true;
            default:
                return false;
        }
    }
    
    public static class Node{
        public int x;
        public int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        Node(int num){
            this.x = (num-1) / 3;
            this.y = (num-1) % 3;
            if(num == 0){
                this.x = 3;
                this.y = 1;
            }
        }
        
        public int dist(Node n){
            return Math.abs(n.x - x ) + Math.abs(n.y -y);
        }
    }
}