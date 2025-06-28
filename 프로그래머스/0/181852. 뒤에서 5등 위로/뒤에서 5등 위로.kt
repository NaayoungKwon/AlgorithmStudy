class Solution {
    fun solution(num_list: IntArray): IntArray {
        return num_list
            .sorted()
            .filterIndexed { index, _ -> index >= 5  }
            .toIntArray()
    }
}