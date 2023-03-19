class Solution {
    int n;
    int[][] pan;
    
    public int solution(int[][] board) {
        n = board.length;
        pan = new int[n][n];
        int answer = n*n;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j] == 1){
                    markDanger(i,j);
                }
            }
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if(pan[i][j] == 1){
                    answer -= 1;
                }
            }
        }
        return answer;
    }
    
    public void markDanger(int i , int j){
        for(int x = Math.max(0,i-1) ; x < Math.min(n,i+2) ; x++){
            for(int y = Math.max(0,j-1) ; y < Math.min(n,j+2) ; y++){
                pan[x][y] = 1;
            }
        }
    }
}