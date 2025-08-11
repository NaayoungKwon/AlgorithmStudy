class Solution {
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        var answer: Int = 0
        val n = storage.size
        val m = storage.get(0).length
        var pan =  storage.map { it.toCharArray().map { c -> c.toString() }.toTypedArray()}.toTypedArray()
        for( request in requests) {
            val useContainer: Boolean = request.length > 1
            val command = request[0].toString()
            val removeSet = mutableSetOf<Node>()
            for (i in 0 until n) {
                for(j in 0 until m){
                    if(command !=  pan[i][j]) continue

                    if(useContainer || isEdge(i, j , pan)){
                        removeSet.add(Node(i, j))
                    }
                }
            }

            for(node in removeSet) {
                pan[node.x][node.y] = "."
            }
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (pan[i][j] != ".") {
                    answer += 1
                }
            }
        }
        return answer
    }

    fun isEdge(a : Int, b : Int, pan : Array<Array<String>>): Boolean {
        val n = pan.size
        val m = pan[0].size
        if (a == 0 || a == n-1 || b == 0 || b == m-1) return true
        val dirs = arrayOf(
            Pair(-1, 0), // up
            Pair(1, 0),  // down
            Pair(0, -1), // left
            Pair(0, 1)   // right
        )
        val list = mutableListOf<Pair<Int, Int>>()
        var visited = Array(n) { BooleanArray(m) { false } }
        list.add(Pair(a,b))
        visited[a][b] = true
        while(list.isNotEmpty()){
            val (x, y) = list.removeAt(0)
            for (dir in dirs) {
                val newX = x + dir.first
                val newY = y + dir.second
                if (newX < 0 || newX >= n || newY < 0 || newY >= m) continue

                if (visited[newX][newY]) continue
                if (pan[newX][newY] == ".") {
                    if (newX == 0 || newX == n - 1 || newY == 0 || newY == m - 1) return true
                    visited[newX][newY] = true
                    list.add(Pair(newX, newY))
                }
            }
        }

        return false
    }
}

data class Node(val x : Int, val y: Int) {

}