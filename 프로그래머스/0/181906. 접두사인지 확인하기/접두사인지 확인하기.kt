class Solution {
    fun solution(my_string: String, is_prefix: String): Int {
        return my_string.startsWith(is_prefix).let { isPrefix ->
            return if (isPrefix) 1 else 0
        }
    }
}