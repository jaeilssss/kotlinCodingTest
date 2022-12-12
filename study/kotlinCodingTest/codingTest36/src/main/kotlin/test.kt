import sun.management.counter.LongCounter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
fun main(){

    var scanner = Scanner(System.`in`)

    var N = scanner.nextInt()

    var M = scanner.nextInt()

    var nList = ArrayList<String>()
    var mList = ArrayList<String>()
    var answer = 0
    for(i in 0 until N){
        nList.add(scanner.next())
    }
    for(i in 0 until M){
        mList.add(scanner.next())
    }

    for(i in mList.indices){

        var s = mList[i]

        for(j in nList.indices){

            var str = nList[j]

            if(str.substring(0,s.length) == s){
                answer++
                break
            }
        }
    }

    println(answer)

}

