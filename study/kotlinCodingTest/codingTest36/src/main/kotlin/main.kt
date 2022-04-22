
import kotlin.math.abs
import java.util.*
import kotlin.collections.ArrayList

fun main()  {


    var scanner = Scanner(System.`in`)


    var n =scanner.nextInt()
    var k = scanner.nextInt()
    var answer =0
    var arr = ArrayList<Int>()
    for(i in 0 until n){
       arr.add(scanner.nextInt())
    }

    arr.sortDescending()
    var index = 0
    while (k!=0){
        if(k/arr[index]!=0){
            var num = k/arr[index]

            k -=num*arr[index]
            answer+=num
        }
        index++
    }
    println(answer)

}