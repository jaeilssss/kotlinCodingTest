import java.util.*
import kotlin.collections.ArrayList

fun main(){
    var array = IntArray(46)

    var n  = readLine()!!.toInt()
    var list = ArrayList<Int>()
    var fibo = ArrayList<Int>()
    array[0]=1
    array[1]=1
    for(i in 0 until n){
        var num = readLine()!!.toInt()
        list.add(num)
    }

    for(i in 2 until 46){
        array[i] = array[i-2]+array[i-1]
    }

    for(i in 0 until n){
        
    }



}


