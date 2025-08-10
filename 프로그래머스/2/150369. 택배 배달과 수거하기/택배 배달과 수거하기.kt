import kotlin.math.max
class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        var i = n-1
        var j = n-1

        i = moveLeftToNonZero(i, deliveries)
        j = moveLeftToNonZero(j, pickups)
        while(i >= 0 || j >= 0){
            val start = maxOf(i,j)
            answer += (start + 1) * 2 // 왕복 거리 계산

            var del_cap = cap
            var a = i
            while(a >= 0 && del_cap > 0){
                if(deliveries[a] <= del_cap){
                    del_cap -= deliveries[a]
                    deliveries[a] = 0 // 다 배달했으니 0으로 설정
                    a -= 1
                } else {
                    deliveries[a] -= del_cap // 남은 양을 차감
                    del_cap = 0 // 더 이상 배달할 수 없음
                }
            }
            i = moveLeftToNonZero(a, deliveries)

            var pick_cap = cap
            var b = j
            while(b >= 0 && pick_cap > 0){
                if(pickups[b] <= pick_cap){
                    pick_cap -= pickups[b]
                    pickups[b] = 0 // 다 수거했으니 0으로 설정
                    b -= 1
                } else {
                    pickups[b] -= pick_cap // 남은 양을 차감
                    pick_cap = 0 // 더 이상 수거할 수 없음
                }
            }
            j = moveLeftToNonZero(b, pickups)
        }
        return answer
    }

    fun moveLeftToNonZero(idx: Int, arr: IntArray): Int {
        var k = idx
        while (k >= 0 && arr[k] == 0) k--
        return k
    }

}