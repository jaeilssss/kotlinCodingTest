import sun.misc.Queue

import kotlin.collections.HashMap
import java.util.*
import kotlin.math.min

var minimum : Long = 1000000000L

fun main() = with(System.`in`.bufferedReader()){
    val (a,b) = readLine().split(" ").map { it.toLong() }

    find(a,b,0)

    if(minimum == 1000000000L){
        println("-1")
    }
    else println(minimum+1)

}

fun find(a : Long, b : Long, count : Long){

    if(a==b) {
        minimum = min(minimum,count)
        return
    }

    else if(a>b){
        return
    }

    find(a*2,b,count+1)
    find((a.toString()+"1").toLong(),b,count+1)
}



