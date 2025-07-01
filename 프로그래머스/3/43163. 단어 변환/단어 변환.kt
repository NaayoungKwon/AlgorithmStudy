class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        val queue = ArrayDeque<Node>()
        queue.add(Node(begin, 0))
        val visited = MutableList(words.size) { false }
        
        while(queue.isNotEmpty()){
//            var onceCheck = false
            val last = queue.removeFirst()
            if(last.value == target){
                return last.count
            }
            
            for(i in words.indices){
                if(visited[i]){
                    continue
                }
//                onceCheck = true
                if(canChange(last.value, words[i])){
                    queue.add(Node(words[i], last.count + 1))
                    visited[i] = true
                }
            }
        }
        return 0
    }

    fun canChange(before: String, after:String): Boolean {
        return 1 == before.toCharArray()
            .filterIndexed(){index, c -> after[index] != c}
            .count()
    }

    open class Node(val value:String, val count: Int){

    }
}