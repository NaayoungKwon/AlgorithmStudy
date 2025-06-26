class Solution {
    fun solution(my_string: String): Array<String> {
        return (1..my_string.length)
            .map { i -> my_string.substring( my_string.length-i, my_string.length) }
            .distinct()
            .sorted()
            .toTypedArray()
    }
}