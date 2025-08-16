import java.util.*
import kotlin.math.abs
class Solution {
fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
    var answer: String = ""
    val distance = abs(x-r) + abs(y-c)
    if(k < distance || (k - distance) % 2 > 0){
        return "impossible"
    }

//    val p = ((k-distance)/2) + 1
//    var visited = Array(n+1) { IntArray(m+1) { p } }
    val dirs = arrayOf(
        Pair("d", Pair(1, 0)), // down
        Pair("l", Pair(0, -1)), // left
        Pair("r", Pair(0, 1)), // right
        Pair("u", Pair(-1, 0)) // up
    )
    val queue = LinkedList<Node>() // 현재까지 위치 누적, x,y

    queue.add(Node(x,y, listOf()))

    while(queue.isNotEmpty()){
        var now = queue.poll()

        for(d in dirs){
            val nx = now.x + d.second.first
            val ny = now.y + d.second.second

            if(nx <= 0 || nx > n || ny <= 0 || ny > m) continue
            val left = abs(nx - r) + abs(ny - c)
            if(left > k - (now.d.size + 1) || (k-(now.d.size + 1)-left) % 2 > 0) continue
//            if(visited[nx][ny] <= 0) continue
            if((now.d.size + 1) == k){
                if(nx == r && ny == c){
                    return now.d.joinToString("") + d.first
                } else continue
            }
//            visited[nx][ny] -= 1
//            println("nd = $nd, nx = $nx, ny = $ny")
            val nd = now.d.plus(d.first)
            queue.add(Node(nx, ny, nd))
            break
        }

    }
    return answer
}


}

data class Node(val x: Int, val y : Int, val d : List<String>){

}