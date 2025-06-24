class Solution {
    fun solution(arr: IntArray, idx: Int): Int {
        return arr
            .withIndex()
            .drop(idx)
            .firstOrNull{it.value == 1}
            ?.index ?: -1
    }
}