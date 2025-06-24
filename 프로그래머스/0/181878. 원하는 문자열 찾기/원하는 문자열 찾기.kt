class Solution {
    fun solution(myString: String, pat: String): Int {
        var answer: Int = 0
        val myString2 = myString.lowercase()
        val pat2 = pat.lowercase()

        val last = myString2.length - pat2.length
        val l = pat2.length
        for(i in 0..last){
            if(myString2.substring(i, i + l).equals(pat2)){
                return 1
            }
        }
        return answer
    }
}