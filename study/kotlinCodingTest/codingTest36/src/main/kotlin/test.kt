import sun.management.counter.LongCounter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
fun main(){

    var scanner = Scanner(System.`in`)


    var n = scanner.nextInt()

    var c = scanner.nextInt()

    var w = scanner.nextInt()

    var answer : Long= Long.MIN_VALUE
    var list = ArrayList<Long>()
    var max : Long= Long.MIN_VALUE
    for(i in 0 until n){
        var n  = scanner.nextLong()

        max = Math.max(max,n)
        list.add(n)
    }
    var zero : Long  = 0

    for(i in 1 .. max){
        var sum  : Long = 0
        for(j in list.indices){
            var cut  : Long= 0

            if(list[j]>=i.toLong()){
                if(list[j].toInt() % (i) ==zero){
                    cut = (list[j]/i) - 1
                }else{
                    cut = list[j]/i
                }
                if((w*i*(list[j]/i)-cut*c)>0){
                    sum += (w*i*(list[j]/i)-cut*c)
                }
            }
        }

        answer = Math.max(answer , sum)
    }

    println(answer)
}

