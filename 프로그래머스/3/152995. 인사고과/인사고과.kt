import kotlin.math.max
import kotlin.math.min

class Solution {

fun solution(scores: Array<IntArray>): Int {
    var answer: Int = 1
    val younho = Pair(scores[0][0],scores[0][1])

    val minSet = mutableSetOf<Int>()
    scores.sortWith(compareBy({ -it[0] }, { it[1] }))
    var mmin = scores[0][1]
    var prevI = 0
    for(i in 1 until scores.size){
        if(scores[i-1][0] > scores[i][0]){ // 증가 구간 발생 = 앞자리가 바뀜
            mmin = max(mmin, scores[i-1][1])
            prevI = i
        }

        if(prevI > 0 && mmin > scores[i][1]){
            minSet.add(i)
            // println(i)
        }
    }
    val ns = scores
        .mapIndexed({ i, score -> Pair(i, score.sum())})
        .filterIndexed({i, _ -> !minSet.contains(i)})
        .sortedBy { -it.second }

    if(minSet.any { younho.first == scores[it][0] && younho.second == scores[it][1] }){
        return -1
    }
    for((i, _) in ns){
        if(younho.first + younho.second == scores[i][0] + scores[i][1]){
            return answer
        }
        answer += 1
    }

    return -1
}
}