import java.util.*

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        var answer = arrayOf<String>()
        tickets.sortWith(compareBy<Array<String>> { it[0] }.thenBy { it[1] })
        val trace = mutableMapOf<String, MutableList<Pair<Int, String>>>()
        val sizeSet = mutableSetOf<String>()

        for(i in tickets.indices){
            val ticket = tickets[i]
            // println("a = ${ticket[0]}, b = ${ticket[1]}")
            sizeSet.add(ticket[0])
            sizeSet.add(ticket[1])
            if(trace.containsKey(ticket[0])){
                trace[ticket[0]]?.add(Pair(i, ticket[1]))
            }else{
                trace[ticket[0]] = mutableListOf(Pair(i, ticket[1]))
            }
        }

        val n = tickets.size
        val queue:Deque<Route> = ArrayDeque()
        queue.add(Route(null, "ICN" , mutableListOf("ICN"), linkedSetOf()))
        // trace.keys.forEach { queue.add(Route(null, it , mutableListOf(it), linkedSetOf())) }

        while(trace.isNotEmpty()){
            val route = queue.poll()
            if(!trace.containsKey(route.end)){
                continue
            }

            for(next in trace.get(route.end).orEmpty()){
                // println("route = $route.end, next = $next")
                // val nextIndex = route.end+next
                 if(route.visited.contains(next.first)){
                     continue
                 }

                val nr = Route(route.end, next.second, route.history + next.second, route.visited + next.first)
                if(nr.history.size == n+1){
                    return nr.history.toTypedArray()
                }
                queue.add(nr)
            }
        }
        return answer
    }
}

data class Route(val start: String?, val end: String, val history: List<String>, val visited: Set<Int>){

}
