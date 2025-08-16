import java.util.*
class Solution {
fun solution(s: String): Int {
    var answer: Int = 0
    val left = setOf('(', '[', '{')
    for(start in s.indices) {
        val st = Stack<Char>()
        for(k in s.indices){
            val e = (start + k) % s.length
            if(left.contains(s[e])){
                st.push(s[e])
            } else if(st.isEmpty()){
                st.push(s[e])
                break
            } else if(s[e] ==')' && st.peek() == '(') {
                st.pop()
            } else if(s[e] == ']' && st.peek() == '[') {
                st.pop()
            } else if(s[e] == '}' && st.peek() == '{') {
                st.pop()
            } else {
                break
            }
        }
        if(st.isEmpty()) answer += 1
    }
    return answer
}
}