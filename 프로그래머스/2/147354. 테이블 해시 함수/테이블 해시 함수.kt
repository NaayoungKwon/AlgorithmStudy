class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
    val answer = mutableListOf<Int>()
    // 정렬
    data.sortWith( compareBy<IntArray> { it[col-1] }.thenBy { -it[0] } )
    // begin부터 end 까지 mod 연산해서 합을 구함
    for(i in row_begin .. row_end) {
        val modSum = data[i-1].map { it % (i) }.sum()
        // println(modSum)
        // 그 합을 xor 연산해서 answer에 저장
        answer.add(modSum)
    }
    // 그 합을 xor 연산해서 리턴
    return answer.reduce { a, b -> a xor b }
    }
}