import kotlin.math.min

class Solution {
    fun solution(X: String, Y: String): String {
        val xCount = X.groupingBy { it }.eachCount()
        val yCount = Y.groupingBy { it }.eachCount()
        val result: String =  ('0'..'9')
            .map { ch -> ch to min(xCount.getOrDefault(ch, 0), yCount.getOrDefault(ch, 0)) }
            .filter { it.second > 0 }
            .flatMap { (ch, count) -> List(count) { ch } }
            .sortedDescending()
            .joinToString ("")
            
        return when {
            result.isBlank() -> "-1"
            result.all { it == '0' } -> "0"
            else -> result
        }
    }
}