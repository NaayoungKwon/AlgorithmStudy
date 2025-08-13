import java.util.*
class Solution {
fun solution(maps: Array<String>): Int {
    var answer: Int = 0
    val n = maps.size
    val m = maps[0].length

    var start = Pair(0, 0)
    var raber = Pair(0, 0)
    var end = Pair(0, 0)
    for(i in 0 until n){
        for(j in 0 until m){
            if(maps[i][j] == 'S'){
                start = Pair(i, j)
            } else if(maps[i][j] == 'L') {
                raber = Pair(i, j)
            } else if(maps[i][j] == 'E') {
                end = Pair(i, j)
            }
        }
    }

    var l1 = getDistance(start, raber, maps)
    if(l1 == -1) return -1

    var l2 = getDistance(raber, end, maps)
    if(l2 == -1) return -1

    return l1 + l2
}

fun getDistance(start: Pair<Int, Int>, end: Pair<Int, Int>, maps: Array<String>): Int {
    val dirs = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))
    val n = maps.size
    val m = maps[0].length
    val visited = Array(n) { BooleanArray(m){false} }

    val queue: Queue<Pair<Int, Pair<Int, Int>>> = LinkedList()
    queue.add(Pair(0, start))
    visited[start.first][start.second] = true

    while(queue.isNotEmpty()){
        val (len, node) = queue.poll()

        for(d in dirs){
            val newX = node.first + d[0]
            val newY = node.second + d[1]
            if(newX < 0 || newY < 0 || newX >= n || newY >= m) continue
            if(visited[newX][newY] || maps[newX][newY] == 'X')continue
            if(newX == end.first && newY == end.second){
                return len + 1
            }

            visited[newX][newY] = true
            queue.add(Pair(len+1, Pair(newX, newY)))
        }

    }

    return -1
}

}