import apple.laf.JRSUIConstants

import java.util.*
import kotlin.math.min
import java.lang.StringBuilder
class Solution {
    fun solution(number: String, k: Int): String {
        var answer = StringBuilder()
        var index = -1
        for(i in 0 until number.length-k){
            var max : Char = '0'
            for(j in index+1..k+i){
                if(max<number[j]){
                    max = number[j]
                    index=j
                }
            }
            answer.append(max)
        }

        return answer.toString()
    }


}



fun main(){
        println(Solution().solution("1924",2))
}