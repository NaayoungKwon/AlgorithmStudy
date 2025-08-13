class Solution {
    fun solution(board: Array<String>): Int {
        var answer: Int = -1
        // O 의 수는 X 보다 같거나 한 개 많아야한다.
        // O와 X의 수가 같을 때 O가 빙고이면 안된다.
        // O가 1개 많을 때 X가 빙고이면 안된다.
        val oCount = board.sumOf { it.count { it == 'O' } }
        val xCount = board.sumOf { it.count { it == 'X' } }
        val oIsBingo = isBingo(board, 'O')
        val xIsBingo = isBingo(board, 'X')


        return if(oCount == xCount){
            if(oIsBingo) 0 else 1
        } else if (oCount == xCount + 1) {
            if(xIsBingo) 0 else 1
        } else {
            0
        }
    }

    fun isBingo(board: Array<String>, target: Char): Boolean{
        if(board.any{it == target.toString().repeat(3)}){
            return true
        }

        for(i in 0 until 3){
            if(board[0][i] == target && board[1][i] == target && board[2][i] == target){
                return true
            }
        }
        if(board[0][0] == target && board[1][1] == target && board[2][2] == target){
            return true
        }
        if(board[0][2] == target && board[1][1] == target && board[2][0] == target){
            return true
        }
        return false
    }
}