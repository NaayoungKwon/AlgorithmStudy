class Solution {
    fun solution(arr: IntArray): IntArray {
        return arr.map { a -> 
            when {
                a >= 50 && a % 2 == 0 -> a /2
                a < 50 && a % 2 == 1 -> a * 2
                else -> a
            }
        }.toIntArray()
    }
}