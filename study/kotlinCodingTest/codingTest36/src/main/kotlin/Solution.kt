import kotlin.math.abs

class Solution {
    fun solution(s: String, times: Array<String>): IntArray {
        var answer: IntArray = IntArray(2)


        var start = s.split(":").map { it.toInt() }.toMutableList()

        var check = true
        var count = 0
        for(i in times.indices){

            var time = times[i].split(":").map { it.toInt() }.toMutableList()
            println("${start[0]}  ${start[1]}  ${start[2]}  ${start[3]}  ${start[4]}  ${start[5]}")
            if(start[start.size-1]+time[3]>=60){
                //second
                var gap = start[start.size-1]+time[3]-60

                start[start.size-1] = gap
                start[start.size-2] +=1

            }else{

                start[start.size-1] = start[start.size-1]+time[3]
                println("1 // ${start[start.size-1]+time[3]}")
            }

            if(start[start.size-2]+time[2]>=60){
                //min
                var gap = start[start.size-2]+time[2]-60

                start[start.size-2] = gap
                start[start.size-3] +=1

            }else{
                start[start.size-2] = start[start.size-2]+time[2]
                println("2 // ${start[start.size-2]+time[2]}")
            }

            var hourCheck  =false
            if(start[start.size-3]+time[1]>=24){
                //hour
                var gap = start[start.size-3]+time[1]-24

                start[start.size-3] = gap
                hourCheck = true
                time[0]++
            }else{
                hourCheck = false
                start[start.size-3]+=time[1]
                println("3 // ${start[start.size-3]+time[1]}")

            }

            if(start[start.size-4]+time[0]!=start[start.size-4]){
                //day

                if(time[0]==1){
                    count++
                    if(start[start.size-4]+time[0]>30){
                        start[start.size-4] = 1
                        start[start.size-5]++
                    }else{
                        start[start.size-4]++
                    }
                }else if(time[0]>=2){

                    println("222")
                    check  = false
                    if(start[start.size-4]+time[0]>30){
                        println(">????")
                        start[start.size-4] = start[start.size-4]+time[0]-30
                        start[start.size-5] += (start[start.size-4]+time[0])%30
                        count +=time[0]
                    }else{
                        start[start.size-4] += time[0]
                        count +=time[0]
                    }
                }



            }else{
                println("4 // ${start[start.size-4]+time[0]}")

            }

            if(start[start.size-4]>12){
                start[start.size-4] -=12
                start[start.size-5] +=1
            }


        }
        if(check){
            answer[0] = 1
            answer[1] = count
        }else{
            answer[0]=0
            answer[1] = count


        }
        println("${answer[0]} // ${answer[1]}")
        return answer
    }
}