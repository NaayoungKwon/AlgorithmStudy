class Solution {
    fun solution(my_strings: Array<String>, parts: Array<IntArray>): String {
        return my_strings
            .mapIndexed{ index, str -> 
                str.substring(parts[index][0], parts[index][1]+1)
        }
            .reduce { acc, s -> acc + s }
    }
}