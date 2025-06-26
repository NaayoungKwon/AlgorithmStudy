class Solution {
    fun solution(number: String): Int {
        return number.toList().map{ it.digitToInt()}.reduce(Int::plus) % 9
    }
}