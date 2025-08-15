import java.util.*
class Solution {
fun solution(n: Int, k: Int, enemy: IntArray): Int {
    var answer: Int = 0
    val pq = PriorityQueue<Int>(Collections.reverseOrder())
    var nn = n
    var kk = k
    for(i in enemy.indices){
        pq.add(enemy[i])
        nn -= enemy[i]
        if(nn < 0){
            while(nn < 0 && kk > 0 && pq.isNotEmpty()){
                val maxEnemy = pq.poll()
                nn += maxEnemy
                kk--
//                print("nn: $nn, kk: $kk, maxEnemy: $maxEnemy, i: $i, enemy[i]: ${enemy[i]}\n")
            }
            if(nn < 0){
                return i
            }
        }
    }
    return enemy.size
}
}