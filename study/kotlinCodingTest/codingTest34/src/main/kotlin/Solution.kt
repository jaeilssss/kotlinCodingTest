class Solution {
    fun solution(numbers: IntArray): Int {
        var answer: Int = 45

        for(i in numbers.indices){
            answer -=numbers[i]
        }
        return answer
    }
}

fun main(){

    println(Solution().solution(intArrayOf(1,2,3,4,6,7,8,0)))
}