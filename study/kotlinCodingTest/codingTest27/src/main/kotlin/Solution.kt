class Solution {
    fun solution(weights: IntArray, head2head: Array<String>): IntArray {
        var answer = IntArray(weights.size)
        var winWeight = IntArray(weights.size)
        var winCount = FloatArray(weights.size)

        for(i in weights.indices){
            winWeight[i]=0
            winCount[i]= 0.0F
            var fightingCount = 0

            var str = head2head[i]
            for(j in str.indices){
                if((str[j] == 'N').not()){
                    fightingCount++
                    if(str[j].equals('W')){
                        winCount[i]++
                        if(weights[j]>weights[i]){
                            winWeight[i]++
                        }
                    }
                }

            }
            if(fightingCount!=0){
                winCount[i]= winCount[i]/fightingCount
            }else {
                winCount[i]=0.0F
            }




        }

        for(i in winCount.indices){
            println(winCount[i])
        }
        for(i in weights.indices){
            var index = 0

            for(j in weights.indices){
                if(winCount[i]<winCount[j]){
                    index++
                }else if(winCount[i]==winCount[j]){
                    if(winWeight[i]<winWeight[j]){
                        index++
                    }else if(winWeight[i]==winWeight[j]){
                        if(weights[i]<weights[j]){
                            index++
                        }
                        if(weights[i]==weights[j]){
                            if(i>j){
                                index++
                            }
                        }
                    }
                }
            }
            answer[index]=i+1
        }
        return answer
    }
}

fun main(){
    println(Solution().solution(intArrayOf(50,82,75,120), arrayOf("NLWL", "WNLL", "LWNW", "WWLN")).toString())
}

