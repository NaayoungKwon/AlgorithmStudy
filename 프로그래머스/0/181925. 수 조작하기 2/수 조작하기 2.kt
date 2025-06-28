class Solution {
    fun solution(numLog: IntArray): String {
        var answer: String = ""
        for(i in 1 .. numLog.size-1){
            val diff = numLog[i] - numLog[i-1]
            when (diff) {
                1 -> answer += "w"
                -1 -> answer += "s"
                10 -> answer += "d"
                -10 -> answer += "a"
            }
        }
        return answer
    }
}