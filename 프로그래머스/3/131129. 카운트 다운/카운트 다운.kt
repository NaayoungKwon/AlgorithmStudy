import java.util.*

class Solution {
    fun solution(target: Int): IntArray {
        var answer: IntArray = intArrayOf()
        val targets = mutableListOf<Target>()
        targets.add(Target(50, 0))
        (1..3).forEach{ level ->
            (1..20).forEach{score -> targets.add(Target(score* level, level))}
        }

        val dp = Array(target+1) {History(count = 0)}
        targets.forEach{
            val m = 0
            if(target >= it.score + m){
                val nh = dp[m].append(it)
                if(nh.compareTo(dp[it.score + m]) < 0) {
                    dp[m + it.score] = nh
                }
            }
        }

        targets.forEach{
            for(m in 0 .. target - it.score ){
                if(dp[m].count > 0){
                    val nh = dp[m].append(it)
                    if(dp[it.score + m].count == 0 || nh.compareTo(dp[it.score + m]) < 0){
                        dp[m + it.score] = nh
                    }
                }
            }
        }
        if(dp[target].count != 0){
            return intArrayOf(dp[target].count, dp[target].singleSum)
        }


        return answer
    }
}

data class Target(val score: Int, val level:Int){

    fun realScore(): Int {
        return if(level == 0) score else score * level
    }

}

data class History(var sum: Int = 0, var count:Int = 0, var singleSum : Int = 0) {

    fun append(target: Target): History {
        return History(sum + target.score,  count + 1, singleSum + (if(target.level <= 1) 1 else 0))
    }

    fun compareTo(other:History):Int {
        if(other.count == 0){
            return -1
        }
        if(this.count == other.count){
            return -(this.singleSum - other.singleSum)
        }
        return this.count - other.count
    }
}

