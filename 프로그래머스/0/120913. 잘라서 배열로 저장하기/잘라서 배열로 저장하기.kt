class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
        val result = mutableListOf<String>()

        for(i in 0 .. my_str.length-1 step  n){
            result.add(my_str.substring(i, Math.min(i+n, my_str.length)))
        }
        return result.toTypedArray()
    }
}