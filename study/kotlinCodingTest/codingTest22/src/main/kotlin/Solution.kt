import kotlin.math.abs

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf(0,0)

        var zeroCount = 0
        var matchNumber= 0

        for(i in lottos.indices){
            if(lottos[i]==0){
                zeroCount++
            }else{
                if(win_nums.contains(lottos[i])){
                    matchNumber++
                }
            }
        }
        answer[0] = checkNumber(matchNumber+zeroCount)
        answer[1] = checkNumber(matchNumber)
        return answer
    }

    fun checkNumber(lotto : Int) : Int{
        if(lotto==6){
            return 1
        }else if(lotto==5){
            return 2
        }else if(lotto==4){
            return 3
        }else if(lotto==3){
            return 4
        }else if(lotto==2){
            return 5
        }else{
            return 6
        }
    }
}