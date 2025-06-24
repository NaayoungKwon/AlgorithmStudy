class Solution {
    fun solution(num_list: IntArray, n: Int): IntArray {
        return num_list.sliceArray(n until num_list.size) + num_list.sliceArray(0 until n)
    }
}