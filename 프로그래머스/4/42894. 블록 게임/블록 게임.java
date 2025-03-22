import java.util.*;
class Solution {
    public int solution(int[][] board) {
        Set<Integer> checked = new HashSet<>();
        Set<Integer> remove = new HashSet<>();
        Set<Integer> cannot = new HashSet<>();
        Set<Block> skip = new TreeSet<>(Block::compareTo);

        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 0 || checked.contains(board[i][j])) {
                    continue;
                }

                int num = board[i][j];
                checked.add(num);

                int type = findType(board, i, j);
                if(type == -1){
                    cannot.add(num);
                    continue;
                }

                boolean flag = true;
                boolean flag2 = true;
                Set<Integer> visited = findTopToBottom(board, type, i, j);
                for(int v : visited){
                    if(v == 0 || remove.contains(v)) {
                        continue;
                    } else if(cannot.contains(v)){
                        flag2 = false;
                        break;
                    } else {
                        flag = false;
                    }
                }

                if(!flag2){
                    cannot.add(num);
                } else if(flag){
                    remove.add(num);
                } else {
                    skip.add(new Block(num, type, i, j));
                }

            }
        }

        boolean retry = true;
        while(retry && !skip.isEmpty()){
            retry = false;
            for(Block block : skip.toArray(new Block[0])){
                int num = block.num;
                int type = block.type;
                int i = block.x;
                int j = block.y;

                boolean flag = true;
                boolean flag2 = true;

                Set<Integer> visited = findTopToBottom(board, type, i, j);
                for(int v : visited){
                    if(v == 0 || remove.contains(v)) {
                        continue;
                    } else if(cannot.contains(v)){
                        flag2 = false;
                        break;
                    } else {
                        flag = false;
                    }
                }

                if(!flag2){
                    cannot.add(num);
                    skip.remove(block);
                } else if(flag){
                    remove.add(num);
                    skip.remove(block);
                    retry = true;
                }
            }
        }

        return remove.size();
    }

    private Set<Integer> findTopToBottom(int[][] board, int type, int i, int j){
        Set<Integer> visited = new HashSet<>();
        if(type == 1){
            for(int k = 0 ; k < i+2 ; k++){
                visited.add(board[k][j+1]);
            }
        } else if (type == 2){
            for(int k = 0 ; k < i+2 ; k++){
                visited.add(board[k][j-1]);
            }
        } else if (type == 3){
            for(int k = 0 ; k < i+1 ; k++){
                int a = board[k][j+1];
                int b = board[k][j+2];
                visited.add(a);
                visited.add(b);
            }
        } else if (type == 4){
            for(int k = 0 ; k < i+1 ; k++){
                int a = board[k][j-1];
                int b = board[k][j-2];
                visited.add(a);
                visited.add(b);
            }
        } else if (type == 5){
            for(int k = 0 ; k < i+1 ; k++){
                int a = board[k][j-1];
                int b = board[k][j+1];
                visited.add(a);
                visited.add(b);
            }
        }
        return visited;
    }

    private int findType(int[][] board, int x, int y){
        int n = board.length, m = board[0].length;

        int num = board[x][y];
        if(x+2 < n && y+1 < m && board[x+1][y] == num && board[x+2][y] == num && board[x+2][y+1] == num){
            return 1;
        } else if (x+2 < n && y-1 >= 0 && board[x+1][y] == num && board[x+2][y] == num && board[x+2][y-1] == num){
            return 2;
        } else if (x+1 < n && y+2 < m && board[x+1][y] == num && board[x+1][y+1] == num && board[x+1][y+2] == num){
            return 3;
        } else if (x+1 < n && y-2 >= 0 && board[x+1][y] == num && board[x+1][y-1] == num && board[x+1][y-2] == num){
            return 4;
        } else if (x+1 < n && y+1 < m && y-1 >= 0 && board[x+1][y+1] == num && board[x+1][y] == num && board[x+1][y-1] == num){
            return 5;
        }
        return -1;
    }

    public static class Block{
        int num; // 블록 번호
        int type; // 어떤 모양인지
        int x; // 블록 시작점
        int y;

        public Block(int num, int type, int x, int y) {
            this.num = num;
            this.type = type;
            this.x = x;
            this.y = y;
        }

        public int compareTo(Block b){
            if(this.x != b.x){
                return this.x - b.x;
            }
            return this.y - b.y;
        }
    }
}