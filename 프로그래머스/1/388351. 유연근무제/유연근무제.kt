import java.time.LocalTime

class Solution {
    fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {
        var answer: Int = 0
                for(i in schedules.indices) {
            val schedule = LocalTime.of(schedules[i] / 100, schedules[i] % 100).plusMinutes(10)
            var isAvailable = true
            for(d in 0..6){
                val today = (startday + d -1) % 7
                if(today >= 5){
                    continue
                }

                if(schedule.isBefore(LocalTime.of(timelogs[i][d] / 100, timelogs[i][d] % 100))) {
                    isAvailable = false
                    break
                }
            }
            
            if(isAvailable){
                answer += 1
            }
        }
        return answer
    }
}