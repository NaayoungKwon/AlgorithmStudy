class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {
        var boxes = MutableList(w) { mutableSetOf<Int>()}
        var boxMap = mutableMapOf<Int, Int>()
        for(i in 1..n){
            val d: Int = if(((i-1) / w) % 2 == 0) 1 else -1
            val start: Int = if(((i-1) / w) % 2 == 0) 0 else w-1
            val floor: Int = (i-1)/w
            val index = start + (i - floor * w -1) * d
            boxes[index].add(i)
            boxMap[i] = index
//            println("$i -> $index (floor: $floor, start: $start, d: $d)")
        }
        
        return boxes[boxMap[num]!!].count() { bi -> bi >= num }
    }
}