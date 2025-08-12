import kotlin.math.max
class Solution {
    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {
        var answer: Int = info.map { it[0] }.sum()
        val EMPTY = 0
        var dp = IntArray(m){EMPTY}

        info.sortedBy { -it[1] }
            .filter { it[1] < m }
            .forEach {
                val a = it[0]
                val b = it[1]
                for(i in m-1-b downTo b){
                    if(dp[i] == EMPTY) continue
                    dp[i+b] = max(dp[i+b], dp[i] + a)
                }
                dp[b] = max(dp[b], a)
            }
        val a = answer - dp.maxOf { it }
        return if(a >= n) -1 else a
    }
}