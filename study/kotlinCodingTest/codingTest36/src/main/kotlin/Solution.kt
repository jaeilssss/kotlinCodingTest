import java.lang.StringBuilder
import kotlin.math.min

class Solution {
    fun solution(s: String): Int {
        var answer = s.length
        var startIndex = 1
        var endIndex = 1
        var count = 1

        while(endIndex<=s.length){
            var str = s.substring(0,endIndex)
            var isChange  = false
            var temp = ""
            var sb = StringBuilder()
            count=1
            startIndex = endIndex
            while(startIndex+endIndex<=s.length){
                var sub = s.substring(startIndex,endIndex+startIndex)
                if(sub==str){
                    isChange = true
                    count++
                    temp = count.toString()+str
                }else{
                    if(isChange){
                    sb.append(temp)

                    }else{
                        sb.append(str)
                    }
                    isChange = false
                    str = sub
                    count =1
                    temp =""
                }
                startIndex +=endIndex

            }

            if(temp.isEmpty()){
            sb.append(s.substring(startIndex-endIndex,s.length))
            }else{
                sb.append(temp+s.substring(startIndex,s.length))
            }

            answer = min(answer,sb.length)
            endIndex++
        }
        return answer
    }
}

fun main(){

    println(Solution().solution("ababcdcdababcdcd"))
}


