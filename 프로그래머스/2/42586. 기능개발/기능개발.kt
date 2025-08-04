import java.util.*
class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()
    // 각각 몇일이 걸리는지를 계산한 배열을 만든다.
    // 맨 첫 번째껄 일단 큐에 넣어놔
    // 두 번째 요소부터 보는데, 큐에 있는 값 보다 작으면 넣어놔/ 만약 큐에 있는 값보다 크면 큐의 제일 앞의 값을 꺼내면서 나보다 큰 값이 나올 때까지 계속 빼
    // 이렇게 뺀 것들의 수를 세서 answer에 넣는다.
    val daysToWork = mutableListOf<Int>()
    for(i in 0 until progresses.size) {
        daysToWork.add(Math.ceil(((100 - progresses[i]).toDouble() / speeds[i].toDouble())).toInt())
    }
    val queue: Queue<Int> = LinkedList()
    for(i in 0 until progresses.size) {
        if(queue.isEmpty() || queue.peek() >= daysToWork[i]){
            queue.add(daysToWork[i])
        } else{
            var count = 0
            while(queue.isNotEmpty() && queue.peek() < daysToWork[i]) {
                queue.poll()
                count += 1
            }
            answer.add(count)
            queue.add(daysToWork[i])
        }
    }
    if(queue.isNotEmpty()){
        answer.add(queue.size)
    }
//    println(answer.toString())
    return answer.toIntArray()
    }
}