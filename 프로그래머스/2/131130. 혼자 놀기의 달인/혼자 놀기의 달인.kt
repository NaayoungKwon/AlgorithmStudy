import java.util.*
class Solution {
    fun solution(cards: IntArray): Int {
        var answer: Int = 0

        val visited = BooleanArray(cards.size)
        val queue = PriorityQueue<Int>()
        for(i in cards.indices) {
            if(visited[i]){
                continue
            }
            visited[i] = true

            var count = 1
            var next = cards[i]
            while(!visited[next - 1]) {
                visited[next - 1] = true
                next = cards[next - 1]
                count++
            }
            queue.add(-count)

        }

        if(queue.size >= 2){
            return queue.poll() * queue.poll()
        }
        return answer
    }
}