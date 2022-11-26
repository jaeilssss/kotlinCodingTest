import java.util.*
import kotlin.collections.ArrayList

fun main(){

    var scanner = Scanner(System.`in`)
    var num = readLine()!!.toInt()

    var list = ArrayList<Int>()

    var arr = IntArray(num*num)

    for(i in 0 until num*num){

        arr[i] = scanner.nextInt()
    }

    Arrays.sort(arr)

    println(arr[num*num-num])


}








