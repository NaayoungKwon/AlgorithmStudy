class Solution {
    fun solution(array: IntArray): Int {
        return array.map { it.toString() }
            .map { it -> it.replace(Regex("[^7]"), "").toList() }
            .flatten()
            .count()
    }
}