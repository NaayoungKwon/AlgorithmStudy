import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = IntArray(numbers.size){-1}
        var st = Stack<Pair<Int,Int>>()

        for(i in numbers.indices) {
            val num = numbers[i]
            while(st.isNotEmpty() && st.peek().second < num){
                val p = st.pop()
                answer[p.first] = num
            }
            st.add(Pair(i,num))
        }
        return answer
    }
}