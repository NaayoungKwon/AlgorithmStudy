import java.util.*

class Solution {
fun solution(order: IntArray): Int {
    var answer: Int = 0
    // 3/1
    // 4/2
    //2/3
    //1/4
    //5/5
    val pq = PriorityQueue<Pair<Int,Int>>(compareBy { it.second })
    order.forEachIndexed { index, o ->
        pq.add(Pair(index+1, o))
    }

    val subConveyor = Stack<Int>()
    var current = 1
    while(pq.isNotEmpty()){
        val (realOrder, _ ) = pq.poll()
        var flag = false

        while(subConveyor.isNotEmpty()){
            if(subConveyor.peek() == current){
                // println("peek current from sub : $current")
                subConveyor.pop()
                current += 1
//                flag = true
            } else {
                break
            }
        }

        if(current == realOrder) {
            // println("peek current from pri : $current")
            current+= 1
//            flag = true
        } else {
            subConveyor.push(realOrder)
            // println("push to sub : $realOrder")
        }

    }

    while(subConveyor.isNotEmpty()){
        if(subConveyor.peek() == current){
            // println("peek current from sub : $current")
            subConveyor.pop()
            current += 1
//                flag = true
        } else {
            break
        }
    }
    
    return current-1
}

}