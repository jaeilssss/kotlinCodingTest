

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


    var count = scanner.nextInt()

    var str = scanner.next().toCharArray().map { it.toString() }
    str = str.sorted()
    var answer = 0
    for(i in 0 until count-1){
        var carr = scanner.next().toCharArray().map { it.toString() }.toMutableList()

        carr = carr.sorted() as MutableList<String>
        if(carr.size==str.size){

            var check = 0
            var temp = str.toMutableList()
            for(j in carr.indices){
                if(temp.contains(carr[j])){
                    var idx = temp.indexOf(carr[j])
                    temp[idx]= "-${carr[j]}"
                }else{
                    check ++
                }
            }
            if(check<=1) {
                answer++
            }
        }else if(carr.size-1 == str.size || carr.size+1 == str.size){
            var check  = true
            var temp = str.toMutableList()
            if(carr.size-1 == temp.size){
                for(j in temp.indices){
                    if(carr.contains(temp[j])){
                        var idx = carr.indexOf(temp[j])
                        carr[idx]= "-${temp[j]}"
                    }else{
                        check = false
                        break
                    }
                }


            }else{

                for(j in carr.indices){
                    if(temp.contains(carr[j])){
                        var idx = temp.indexOf(carr[j])
                        temp[idx]= "-${carr[j]}"
                    }else{
                        check = false
                        break
                    }
                }
            }

            if(check) answer++
        }
    }

    println(answer)
}

class Beer(var v : Int , var c : Int){


}











