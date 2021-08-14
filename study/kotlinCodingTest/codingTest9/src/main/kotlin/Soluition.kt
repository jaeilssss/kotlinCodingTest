 class Solution {
    fun solution(scores: Array<IntArray>): String {
        var answer = ""
        var result = 0f
        for (i in scores.indices) {
            var sum = 0
            var cnt = 0
            var max = -1
            var min = 101
            for (j in scores.indices) {
                sum += scores[j][i]
                if (j != i && scores[i][i] == scores[j][i]) {
                    cnt++
                }
                max = Math.max(max, scores[j][i])
                min = Math.min(min, scores[j][i])
            }
            result = if (cnt == 0) {
                if (scores[i][i] == max || scores[i][i] == min) {
                    (sum - scores[i][i]).toFloat() / (scores.size - 1)
                } else {
                    sum.toFloat() / scores.size
                }
            } else {
                sum.toFloat() / scores.size
            }
            answer += if (result >= 90) {
                "A"
            } else if (result >= 80) {
                "B"
            } else if (result >= 70) {
                "C"
            } else if (result >= 50) {
                "D"
            } else "F"
        }
        return answer
    }
}