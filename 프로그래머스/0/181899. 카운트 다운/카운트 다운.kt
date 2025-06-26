class Solution {
    fun solution(start_num: Int, end_num: Int): IntArray {
        val result = mutableListOf<Int>()
        for (i in start_num downTo  end_num) {
            result.add(i)
        }
        return result.toIntArray()
    }
}