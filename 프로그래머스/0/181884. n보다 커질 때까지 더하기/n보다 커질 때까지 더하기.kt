class Solution {
    fun solution(numbers: IntArray, n: Int): Int {
        var answer: Int = 0
        for(num in numbers){
            if(answer > n){
                break
            }
            answer += num
        }
        return answer
    }
}