class Solution {
    fun getL(l1: Int, l2: Int, start:Int, end:Int): Int{
        return if(end < l1){
            l2+ start + end
        } else if (end >= l1 && start < l1){
            start + (end - l1)
        } else {
            300_000 *2
        }
    }

    fun solution(queue1: IntArray, queue2: IntArray): Int {
        // queue1 + queue2를 하면서 합을 구한다
        // 합/2의 값이 구간에서 어디인지를 찾는다.
        var sum:Long = 0L
        val nq = mutableListOf<Int>()
        for(e in queue1){
            nq.add(e)
            sum += e
        }
        for(e in queue2){
            nq.add(e)
            sum += e
        }
        if((sum % 2).toInt() == 1){
            return -1
        }
        sum /= 2

        var start = 0
        var end = 0
        var accum: Long = 0L
        val MAX:Int = 300_000 *2
        var minCount = MAX
        var l1 = queue1.size
        var l2 =  queue2.size
        while(start <= end && end < nq.size){
            if(accum == sum){
                val l = getL(l1, l2, start, end)
                minCount = Math.min(minCount, l)
                // println("start $start, end $end, l $l")
                accum += nq[end]
                end += 1
            } else if (accum < sum){
                accum += nq[end]
                end += 1
            } else {
                accum -= nq[start]
                start += 1
            }
        }

        start = 0
        end = 0
        accum = 0L
        l1 = queue2.size
        l2 =  queue1.size
        nq.clear()
        for(e in queue2){
            nq.add(e)
        }
        for(e in queue1){
            nq.add(e)
        }
        while(start <= end && end < nq.size){
            if(accum == sum){
                val l = getL(l1, l2, start, end)
                minCount = Math.min(minCount, l)
                // println("start $start, end $end, l $l")
                accum += nq[end]
                end += 1
            } else if (accum < sum){
                accum += nq[end]
                end += 1
            } else {
                accum -= nq[start]
                start += 1
            }
        }

        return if (minCount < MAX) minCount else -1
    }
}