class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        return (1..number)
            .map{i ->
                val count = countDivisor(i)
                if(count > limit) power else count
            }
            .sum()
    }

    fun countDivisor(n: Int): Int { 
        val last = Math.sqrt(n.toDouble()).toInt() 
        val count = (1..last)
           .count{it -> n % it == 0}
        return count * 2 + (if (last * last == n) -1 else 0)
    }
}