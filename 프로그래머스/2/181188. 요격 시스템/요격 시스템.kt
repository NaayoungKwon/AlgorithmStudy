class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0

        var e = -1
        var s = -1
        targets.sortedWith( compareBy<IntArray> { it[1]}.thenBy { it[0] })
            .forEach{
                if(it[0] >= e){
                    answer += 1
                    s = it[0]
                    e = it[1]
                }
            }
        return answer
    }
}