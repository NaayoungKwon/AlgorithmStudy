class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var start: Node = (0 until park.size).flatMap { x ->
            (0 until park[x].length).map { y ->
                if (park[x][y] == 'S') Node(x, y) else null
            }
        }.first { it != null } !!
        // println("start: ${start.x} ${start.y}")

        var now = start
        val n = park.size
        val m = park[0].length
        for(route in routes) {
            val (b,  a) = route.split(" ")
            val l = a.toInt()
            val d = Dir.valueOf(b)
            if(now.x + d.dx * l < 0 || now.x +d.dx * l >= n || now.y +d.dy * l < 0 || now.y + d.dy * l >= m) {
                continue
            }
            var flag = true
            for(i in 1..l) {
                val next = now.move(d, i)
                // println("next: ${next.x} ${next.y}")
                if(park[next.x][next.y] == 'X') {
                    flag = false
                    break
                }
            }
            if(!flag) {
                continue
            }
            now = now.move(d, l)
            // println("now: ${now.x} ${now.y}")
        }

        return intArrayOf(now.x, now.y)
    }

    enum class Dir(val dx: Int, val dy: Int) {
        E(0, 1), W(0, -1), S(1, 0), N(-1, 0)
    }

    open class Node(val x: Int, val y: Int) {

        fun move(dir: Dir, n: Int): Node {
            return Node(x + dir.dx * n, y  + dir.dy * n)
        }
    }
}