
import kotlin.math.abs
import java.util.*

fun main()  {


    var scanner = Scanner(System.`in`)

    var n = scanner.nextInt()
    var k = scanner.nextInt()
    var str = scanner.next().toCharArray()

    var answer = 0

    for(i in str.indices){
        var start=0
        var end = 0
        if(i-k <0){
            start= i+1
        }else{
            start = i-k
        }

        if(i+k>=str.size){
            end = str.size-1
        }else{
            end = i+k
        }

        for(j in start until end+1){
            if((str[i]=='H' && str[j]=='P') ||
                (str[i]=='P' &&str[j]=='H')){
                answer++
                str[i]='/'
                str[j]='/'
                break
            }
        }
    }

    println(answer)
}