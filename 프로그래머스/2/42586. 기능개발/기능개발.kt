import java.util.*
import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    var answer = mutableListOf<Int>()

    val daysToWork = mutableListOf<Int>()
    for(i in 0 until progresses.size) {
        daysToWork.add(ceil(((100 - progresses[i]).toDouble() / speeds[i].toDouble())).toInt())
    }
    var queue: Queue<Int> = LinkedList()
    for(i in 0 until progresses.size) {
        if(queue.isEmpty() || queue.peek() >= daysToWork[i]){
            queue.add(daysToWork[i])
        } else{
            answer.add(queue.size)
            queue = LinkedList()
            queue.add(daysToWork[i])
        }
    }
    // if(answer.isNotEmpty()){
    answer.add(queue.size)
    // }
//    println(answer.toString())
    return answer.toIntArray()
    }
}