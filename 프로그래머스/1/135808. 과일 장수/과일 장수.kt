class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        return score
            .sortedDescending()
            .chunked(m)
            .filter { it -> it.size == m }
            .sumOf { l -> (l.minOrNull() ?: 0) * m }
    }
}