import java.util.*
class Solution {
    fun solution(p: String): String {
        var answer = ""
        var left = 0
        var right = 0
        if(isBalanced(p)){
            return p
        }

        for(i in p.indices){
            if(p[i]  == '('){
                left++
            } else {
                right++
            }

            if(left != right){
                continue
            }

            val v = solution(p.substring(i + 1))
            val u = p.substring(0, i + 1)
    //        println("u: $u, v: $v")
            if(isBalanced(u)){
                return u+ v
            } else {
                val r =  "(${v})${u.substring(1, u.length - 1).map { if (it == '(') ')' else '(' }.joinToString("")}"
    //            println("r: $r, convert u : ${u.substring(1, u.length - 1).map { if (it == '(') ')' else '(' }.joinToString("")}")
                return r
            }
        }
        return answer
    }

    fun isBalanced(p: String): Boolean{
        val st = Stack<Char>()
        for (c in p) {
            if (c == '(') {
                st.push(c)
            } else {
                if(st.isNotEmpty() && st.peek() == '(') {
                    st.pop()
                } else {
                    return false
                }
            }
        }
        return st.isEmpty()

    }
}