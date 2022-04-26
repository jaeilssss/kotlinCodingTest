
import java.util.*
import kotlin.collections.ArrayList

fun main()  {


    var scanner = Scanner(System.`in`)


    var count = scanner.nextInt()
    var answer= 0

    for(i in 0  until count){

        var list = ArrayList<String>()

        var str = scanner.next()
        var check = true
        for(i in str.indices){
            if(!list.contains(str.substring(i,i+1))){
                list.add(str.substring(i,i+1))
            }else {
                if(str.subSequence(i-1,i)!=str.subSequence(i,i+1)){
                    check = false
                }
            }
        }

        if(check){
            answer++
        }
    }

    println(answer)
}