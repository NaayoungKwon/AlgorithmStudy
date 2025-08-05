
import kotlin.math.max
class Solution {


//class Solutions

fun <T> permutation(el: List<T>, fin: List<T> = listOf(), sub: List<T> = el ): List<List<T>> {
    return if(sub.isEmpty()) listOf(fin)
    else sub.flatMap { permutation(el, fin + it, sub - it) }
}

fun solution(k: Int, dungeons: Array<IntArray>): Int {
    var answer: Int = 0
    // Queue에다가 넣어서 하나 씩 꺼낸다.
    // i를 갔을 때 얼마나 소모했는지
    // i를 안갔을 때 얼마나 소모했는지
    val n = dungeons.size
    permutation(dungeons.indices.toList()).forEach{
        var nk: Int = k
        for(i in 0 until n){
            val d = dungeons.get(it.get(i))
            if(nk >= d[0]){
                nk -= d[1]
                if(nk >= 0){
                    answer = max(answer , i+1)
                } else {
                    break
                }
            } else {
                break
            }

        }

    }
    return answer
}
}