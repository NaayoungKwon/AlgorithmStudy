class Solution {
    fun solution(topping: IntArray): Int {
    var answer: Int = 0
    val me = mutableMapOf<Int, Int>()
    val you = mutableMapOf<Int, Int>()
    val l = topping.size

    for(i in 0 until l){
        you.put(topping[i], you.getOrDefault(topping[i] , 0) + 1)
    }

    for(i in 0 until l){
        val topp = topping[i]
        me.put(topp, me.getOrDefault(topp , 0) + 1)
        you.put(topp, you.getOrDefault(topp,0)-1)
        if(you.getOrDefault(topp,0) <= 0){
            you.remove(topp)
        }
        if(me.keys.size == you.keys.size){
            answer += 1
        }
    }

    return answer
    }
}