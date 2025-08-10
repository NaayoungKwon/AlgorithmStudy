class Solution {
    fun solution(numbers: IntArray): String {
        val result = numbers.sortedBy { -it.toString().repeat(6).substring(0, 6).toInt() }
            .map{ it.toString()}
            .joinToString ("")
        if(result.toSet().size == 1 && result[0] == '0') {
            return "0"
        }
        return result
    }
}