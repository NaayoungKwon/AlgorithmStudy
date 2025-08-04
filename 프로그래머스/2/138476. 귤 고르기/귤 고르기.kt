import java.util.*
class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var sum = 0
        // map으로 각 귤 크기 별 갯수를 센다
        // sort를 하는데 내림차순으로 해서 하나 씩 꺼내면서 값을 누적했을 때 k 만큼이 되면 그때까지의 종류를 카운팅한다.
        val countingMap = mutableMapOf<Int, Int>()
        for(t in tangerine) {
            countingMap[t] = countingMap.getOrDefault(t, 0) + 1
        }
        val entries = LinkedList(countingMap.entries)
        entries.sortBy { -it.value }
        for(e in entries){
            answer++
            sum += e.value
            if(sum >= k) {
                break
            }
        }
        return answer
    }
}