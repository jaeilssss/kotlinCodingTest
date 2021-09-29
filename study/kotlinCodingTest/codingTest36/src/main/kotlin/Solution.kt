import java.util.*
import kotlin.math.max

class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var max = 0
        var min = 0
        if(sizes[0][0]>sizes[0][1]){
            max = sizes[0][0]
            min = sizes[0][1]
        }else{
            max = sizes[0][1]
            min = sizes[0][0]
        }

        for(i in 1 until sizes.size) {
            var tempMax = 0
            var tempMin =0
            if(sizes[i][0]>sizes[i][1]){
                tempMax = sizes[i][0]
                tempMin = sizes[i][1]
            }else{
                tempMax = sizes[i][1]
                tempMin = sizes[i][0]
            }
            if(max<tempMax){
                max  = tempMax
            }
            if(min<tempMin){
                min = tempMin
            }
        }

        return max*min
    }
}

fun main(){
   var num = readLine()?.toInt()
    var numArray = IntArray(num!!)

    var str = readLine()
    var array = str?.split(" ")
    var check = false
    var answer =1
    for(i in 0 until num){
        numArray[i] = array?.get(i)!!.toInt()
    }
    Arrays.sort(numArray)
while(true){

    var temp = answer
    for(i in numArray.size-1 downTo 0){
        if(temp>=numArray[i]){
            if(temp-numArray[i]<0){
                check = true
                break
            }else if(temp-numArray[i]==0){
                break
            }else{
                temp -= numArray[i]
            }
        }
        if(i==0&&temp!=0){
            check =true
        }
    }
    if(check){
        println(answer)
        break
    }else{
        answer++
    }
}
}