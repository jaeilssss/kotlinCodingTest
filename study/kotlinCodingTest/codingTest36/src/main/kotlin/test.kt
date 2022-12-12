import sun.management.counter.LongCounter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

fun main(){

    var scanner = Scanner(System.`in`)


    var  N = scanner.nextInt()

    var max = 0

    var list  = ArrayList<String>()
    for(i in 0 until N){
        list.add(scanner.next())
    }

    list.sortBy { it.length }

    for(i in list.indices){

        var check  = true
        for(j in i+1 until list.size){

            var s = list[i]
            var t = list[j]

            if(t.substring(0,s.length)==s){
                check = false
                break
            }
        }

        if(check){
            max++
        }

    }


    println(max)
}

