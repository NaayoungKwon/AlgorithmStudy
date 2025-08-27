import kotlin.math.min

class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
    var answer = mutableListOf<Int>()
    val MAX = 100 * 200

    // 행렬 초기화
    val matrix = (0 until rows).map { r ->
        (1 .. columns).map { c ->
            r * columns + c
        }.toIntArray()
    }.toTypedArray()

    // 쿼리 돌아가면서 회전시킨다
    for(query in queries){
        var minValue = MAX
        val (x1, y1, x2, y2) = query.map{it -1}

        val queue = ArrayDeque<Int>()
        // 오른쪽
        for(yy in y1..y2){
            queue.add(matrix[x1][yy])
            minValue = min(matrix[x1][yy], minValue)
        }

        // 아래
        for(xx in x1+1..x2){
            queue.add(matrix[xx][y2])
            minValue = min(matrix[xx][y2], minValue)
        }

        // 왼쪽
        for(yy in y2-1 downTo y1){
            queue.add(matrix[x2][yy])
            minValue = min(matrix[x2][yy], minValue)
        }


        // 위로
        for(xx in x2-1 downTo x1){
            queue.add(matrix[xx][y1])
            minValue = min(matrix[xx][y1], minValue)
        }


        val last = queue.removeLast()
        queue.addFirst(last)

        // 오른쪽
        for(yy in y1..y2){
            matrix[x1][yy] = queue.removeFirst()
            // println("$x1,$yy : ${matrix[x1][yy]}")
        }

        // 아래
        for(xx in x1+1..x2){
            matrix[xx][y2] = queue.removeFirst()
            // println("$xx,$y2 : ${matrix[xx][y2]}")
        }

        // 왼쪽
        for(yy in y2-1 downTo y1){
            matrix[x2][yy] = queue.removeFirst()
            // println("$x2,$yy : ${matrix[x2][yy]}")
        }


        // 위로
        for(xx in x2-1 downTo x1){
            matrix[xx][y1] = queue.removeFirst()
            // println("$xx,$y1 : ${matrix[xx][y1]}")
        }

        answer.add(minValue)
    }

    // 할 때 마다 최솟값 업데이트 시킨다

    return answer.toIntArray()
    }
}