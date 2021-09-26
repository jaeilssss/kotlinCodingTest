import kotlin.math.min

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var move = name.length-1
        for(i in name.indices){
            var next = i + 1

                while(next<name.length && name[next] == 'A'){
                    next++
                }

                move = min(move,i+name.length-next +i)

            if(name[i].equals('A').not()){

                    var temp = name[i].toInt()-65
                    if(temp>=13){
                        temp = (26-temp)
                    }
                    answer +=temp
            }
        }

        answer +=move
        return answer
    }
}



fun main(){
println(Solution().solution("JAN"))
}