class Solution {
    fun solution(enter: IntArray, leave: IntArray): IntArray {
        var answer: IntArray = IntArray(enter.size)
        var enterIndex = 0
        var leaveIndex = 0
        var enterHash = HashMap<Int , Int>()
        while (true){
            if(leaveIndex!=leave.size){
                if(enterHash.keys.contains(leave[leaveIndex]).not()){

                    for(key in enterHash.keys){
                        enterHash.put(key , enterHash.get(key)!!+1)
                    }
                    enterHash.put(enter[enterIndex++],enterHash.keys.size)

                }else{
                    answer[leave[leaveIndex]-1] = enterHash.get(leave[leaveIndex])!!
                    enterHash.remove(leave[leaveIndex])
                    leaveIndex++

                }
            }else{
                break
            }
        }

        return answer
    }
}

fun main(){


    var answer = Solution().solution(
        intArrayOf(1,4,2,3),
        intArrayOf(2,1,4,3)
    )
    for(i in answer.indices){
        println(answer[i])
    }
}