import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

fun main(){

    var scanner = Scanner(System.`in`)

    var plusList = ArrayList<Int>()

    var minusList = ArrayList<Int>()

    var N = scanner.nextInt()

    var M = scanner.nextInt()


    var step : Long = 0

    var max = 0
    for(i in 0 until N){

        var n = scanner.nextInt()

        if(n>=0){
            plusList.add(n)
        }else{
            minusList.add(abs(n))
        }
    }

    plusList.sortDescending()
    minusList.sortDescending()

    if(plusList.isEmpty()){
        max = minusList[0]
    }else if(minusList.isEmpty()){
        max = plusList[0]
    }else{
        max = max(plusList[0],minusList[0])
    }


    while(plusList.isNotEmpty() || minusList.isNotEmpty()){

        if(plusList.isNotEmpty()){
            var temp = plusList[0]
            plusList.removeAt(0)
            for(i in 0 until M-1){
                if(plusList.isEmpty()) break
                plusList.removeAt(0)
            }

            step += temp*2
        }
        if(minusList.isNotEmpty()){

            var temp = minusList[0]
            minusList.removeAt(0)
            for(i in 0 until M-1){
                if(minusList.isEmpty()) break
                minusList.removeAt(0)
            }

            step += temp*2
        }


    }

    step -= max

    println(step)


}
