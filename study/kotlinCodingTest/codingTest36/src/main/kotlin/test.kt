

import com.sun.org.apache.xpath.internal.operations.Bool
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main()=with(BufferedReader(InputStreamReader(System.`in`))) {


    var scanner = Scanner(System.`in`)


    var  K = scanner.nextInt()

    var arr = ArrayList<Pair<Int,Int>>()
    var maxHeight = 0
    var maxWidth = 0
    for(i in 0 until 6){
        var d = scanner.nextInt()
        var value = scanner.nextInt()

        if(d==4 || d==3){
            if(maxHeight<value){
                maxHeight = value
            }
        }else {
            if(maxWidth<value){
                maxWidth = value
            }
        }

        arr.add(Pair(d,value))
    }

    var emptyHight = 0
    var emptyWidth = 0
    for(i in arr.indices){

        if(arr[i].first<=2){

            if(arr[(i+5)%6].second + arr[(i+1)%6].second == maxHeight){
                emptyWidth = arr[i].second
            }
        }else{
            if(arr[(i+5)%6].second + arr[(i+1)%6].second == maxWidth){
                emptyHight = arr[i].second
            }
        }
    }
    println(((maxWidth*maxHeight)-(emptyHight*emptyWidth))*K)
}

class Beer(var v : Int , var c : Int){


}











