import java.util.*

class Solution {
    fun solution(maps: Array<String>): IntArray {
    var answer = mutableListOf<Int>()
    val dirs = arrayOf(Pair(0,1), Pair(1,0), Pair(0,-1), Pair(-1,0))
    val nm = maps.map { it.split("").filter { it != "" }.toMutableList() }.toMutableList()
    val n = nm.size
    val m = nm[0].size

    for(i in 0 until nm.size) {
        for(j in 0 until nm[i].size) {
            if(nm[i][j] == "X" || nm[i][j] == ".") {
                continue
            }

            var sum = nm[i][j].toInt()
            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.add(Pair(i, j))
            nm[i][j] = "."

            while(queue.isNotEmpty()){
                val cur = queue.poll()
                for(dir in dirs){
                    val nx = cur.first + dir.first
                    val ny = cur.second + dir.second
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue
                    if(nm[nx][ny] == "X" || nm[nx][ny] == ".") continue
                    sum += nm[nx][ny].toInt()
                    nm[nx][ny] = "."
                    queue.add(Pair(nx, ny))
                }

            }

            answer.add(sum)
        }
    }

    return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }
}