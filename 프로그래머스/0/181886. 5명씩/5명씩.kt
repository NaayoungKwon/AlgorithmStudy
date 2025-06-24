class Solution {
    fun solution(names: Array<String>): Array<String> {
        return names.filterIndexed{i, _ -> i % 5 == 0}.toTypedArray()
    }
}