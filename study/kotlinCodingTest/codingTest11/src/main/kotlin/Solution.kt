class Solution {
    fun solution(num: Int): Int {
        var answer = 0
        var value = num

        while (true) {
            if (value == 1) {
                break
            } else if (answer == 500) {
                answer = -1
                break
            } else {
                answer++
                if (value % 2 == 0) {
                    value /= 2
                } else {
                    var temp  = value.toDouble()
                    temp = temp * 3 + 1
                    value = temp.toInt()
                }
            }


        }
        return answer
    }
}