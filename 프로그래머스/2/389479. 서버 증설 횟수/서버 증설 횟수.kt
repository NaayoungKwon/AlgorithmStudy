import kotlin.math.min
import kotlin.math.max
class Solution {
    fun solution(players: IntArray, m: Int, k: Int): Int {
        var answer: Int = 0
        val tracking = IntRange(0, 24).map { 0 }.toMutableList()

        for(i in IntRange(0, 23)){
            var up = players[i] / m
            up = max(0, up - tracking[i])
            if(up > 0){

                for(j in i until min(24, i+k)){
                    tracking[j] += up
                }
    //            println("i: $i, up: $up")
                answer += up
            }
        }
        return answer
    }
}