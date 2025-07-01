class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var parent = (0 until n).toMutableList()
        for(i in 0 until n){
            for(j in 0 until n){
                if(i == j || computers[i][j] == 0){
                    continue
                }
                val na = find(parent, i)
                val nb = find(parent, j)
                if(na < nb){
                    parent[nb] = na
                } else if (na > nb){
                    parent[na] = nb
                }
            }
        }
        for(i in 0 until n){
            parent[i] = find(parent, i)
        }
        return parent.toSet().size
    }

    fun find(parent: List<Int>, a: Int) :Int{
        if(parent[a] == a){
           return a
        }
        return find(parent, parent[a])
    }
}