import java.util.*
class Solution {
fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
    var answer: Int = 0
    val possible = (1..n).toSet().toIntArray()
    val result = mutableSetOf<Set<Int>>()

    for(com in combination(possible,5)){

        var isPossible = true
        for(i in q.indices){
            if(q[i].toSet().intersect(com).size != ans[i]){
                isPossible = false
                break
            }
        }
        if(isPossible){
            answer += 1
        }
    }
    return answer
}

    fun  combination(elements: IntArray, r: Int): List<Set<Int>> {
        val n = elements.size
        val results = mutableListOf<Set<Int>>() // 모든 경우의 수

        val result = elements.sliceArray(0 until r)

        fun recursionCombination(depth: Int = 0, index: Int = 0) {
            if (depth == r) {
                results.add(result.toSet())
                return
            }

            for (i in index until n) {
                result[depth] = elements[i]
                recursionCombination(depth + 1, i + 1)
            }
        }

        recursionCombination()
        return results
    }

}