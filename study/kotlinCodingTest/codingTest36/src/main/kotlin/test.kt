

import com.sun.org.apache.xpath.internal.operations.Bool
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main()=with(BufferedReader(InputStreamReader(System.`in`))) {


    var scanner = Scanner(System.`in`)


    var N = scanner.nextInt()
    var K = scanner.nextInt()
    var A = scanner.nextInt()
    var B = scanner.nextInt()

    var day = 0
    var initValue = K

    while (true){
        day++

        if(day % (N/A)==0) initValue+=B
         initValue--

        if(initValue==0){
            break
        }
    }

    println(day)
}

class Beer(var v : Int , var c : Int){


}











