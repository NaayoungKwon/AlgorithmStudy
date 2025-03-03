import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(String[] board) {
        // O의 갯수 =  X의 갯수 or +1 만큼이어야한다
        // 둘 중 한명만 빙고인 경우는 1, 둘 다 빙고인 경우는 0
        // O가 빙고인데, (X도 빙고 or X의 수랑 동일하다) -> 0
        // X가 빙고인데, (O도 빙고 or O의 수가 더 많다) -> 0

        // check count
        int oCnt = 0, xCnt = 0,  commaCnt = 0;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                oCnt += board[i].charAt(j) == 'O' ? 1 : 0;
                xCnt += board[i].charAt(j) == 'X' ? 1 : 0;
                commaCnt += board[i].charAt(j) == '.' ? 1 : 0;
            }
        }
        if(!(oCnt == xCnt || oCnt == xCnt + 1)){
            return 0;
        }

        // check is bingo
        int isOBingo = 0, isXBingo = 0;
        for(int i = 0 ; i < 3 ; i++){
            Set<String> set = Arrays.stream(board[i].split("")).collect(Collectors.toSet());
            if(set.size() == 1 && set.contains("O")){
                isOBingo += 1;
            } else if (set.size() == 1 && set.contains("X")){
                isXBingo += 1;
            }
            HashSet<String> colSet = new HashSet<>(List.of(board[0].charAt(i) + "", board[1].charAt(i) + "", board[2].charAt(i) + ""));
            if(colSet.size() == 1 && colSet.contains("O")){
                isOBingo += 1;
            } else if (colSet.size() == 1 && colSet.contains("X")){
                isXBingo += 1;
            }
        }
        // 대각선이 빙고인지 확인
        Set<String> diagonal1 = new HashSet<>(List.of(board[0].charAt(0) + "", board[1].charAt(1) + "", board[2].charAt(2) + ""));
        Set<String> diagonal2 = new HashSet<>(List.of(board[0].charAt(2) + "", board[1].charAt(1) + "", board[2].charAt(0) + ""));
        if((diagonal1.size() == 1 && diagonal1.contains("O")) || (diagonal2.size() == 1 && diagonal2.contains("O"))){
            isOBingo +=1 ;
        } else if ((diagonal1.size() == 1 && diagonal1.contains("X")) || (diagonal2.size() == 1 && diagonal2.contains("X"))){
            isXBingo += 1;
        }

        if(isXBingo > 1 && isOBingo > 1){
            return 0;
        } else if ((isXBingo > 1 || isOBingo > 1) && commaCnt > 0  ) {
            return 0;
        }else if (isOBingo == 1 && isXBingo == 1){
            return 0;
        } else if (isOBingo == 1 && oCnt == xCnt){
         return 0;
        } else if (isXBingo == 1 && oCnt > xCnt){
            return 0;
        }
        return 1;
    }
}