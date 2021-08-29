import java.util.*

import kotlin.math.max
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = ArrayList<Int>()

        var currentStage = HashMap<Int,Int>()
        var stageCount = HashMap<Int,Int>()
        var list = ArrayList<Double>()

        for(i in 1..N){
            stageCount.put(i,0)
            currentStage.put(i,0)
        }
        for(i in stages.indices){

                if(currentStage.containsKey(stages[i])){
                    var num = currentStage.get(stages[i])?.plus(1)
                    if (num != null) {
                        currentStage[stages[i]] = num
                    }
                }


        }

        for(i in stages.indices){
            for(j in 1..stages[i]){

                    if(stageCount.containsKey(j)){
                        var num = stageCount[j]?.plus(1)
                        if(num !=null){
                            stageCount.put(j,num)
                        }
                    }

            }
        }

        for(i in currentStage.keys){
            var num = 0.0
            if(stageCount[i]!=0){
                num = stageCount[i]?.let { currentStage[i]?.toDouble()?.div(it) }!!
            }
            if (num != null) {
                list.add(num)
            }
        }



        for(i in list.indices){
            var maxIndex = list.indexOf(list.max())

            answer.add(maxIndex+1)
            list[maxIndex] = -1.0
        }

        return answer.toIntArray()
    }
}
fun main(){
    var stages = intArrayOf(1,2,2,1,3)

    var array = Solution().solution(5,stages)

    for(i in array.indices){
        print(array[i])
        print(" ")
    }
}