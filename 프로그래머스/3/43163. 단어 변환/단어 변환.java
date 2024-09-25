import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(begin, 0));
        
        while(que.size() > 0){
            Node node = que.poll();
            
            if(node.word.equals(target)){
                return node.cnt;
            } else if(node.cnt > words.length){
                continue;    
            }
            
            for(int i = 0 ; i < words.length; i++){
                if(canChange(node.word, words[i])){
                    // System.out.println(node.word + " "+ node.cnt +" "+ words[i]);
                    que.add(node.createNew(words[i]));
                }
            }
            
        }
        return answer;
    }
    
    public boolean canChange(String before, String after){
        if(before.length() != after.length()){
            return false;
        }
        
        int cnt = 0;
        for(int i = 0 ; i < before.length(); i++){
            if(before.charAt(i) != after.charAt(i)){
                cnt += 1;
            }
        }
        
        return cnt == 1 ? true : false;
    }
    
    public static class Node{
        String word;
        int cnt;
        
        Node(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
        
        public Node createNew(String newWord){
            return new Node(newWord, this.cnt + 1);
        }
    }
}