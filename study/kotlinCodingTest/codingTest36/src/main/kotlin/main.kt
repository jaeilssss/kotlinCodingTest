import kotlin.math.abs
val bre = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    var count = bre.readLine().toInt()


    var list = ArrayList<Int>()
    var sum = 0
    var max = 0
    for(i in 0 until count){
        var num = bre.readLine().toInt()
        sum += num
        list.add(num)
    }

    list.sortDescending()
    max  = list[0]
    sum = list[0]
    for(i in 1 until list.size){

        var temp   = sum+list[i]

        if(temp.toDouble()/(i+1) >list[i].toDouble()){
            temp = list[i]*(i+1)
        }

        if(temp>max){
            max = temp
            sum = temp
        }

    }
    println(max)
}