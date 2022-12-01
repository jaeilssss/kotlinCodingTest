import sun.management.counter.LongCounter
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashSet

fun main(){

    var scanner = Scanner(System.`in`)

    var num = scanner.nextInt()

    var set = HashSet<String>()
    var cnt = 0
    var answer = StringBuffer()
    var mainShape = StringBuffer()
    for(i in 0 until num){
         mainShape.append(scanner.next())
    }


    var forward = StringBuffer()
    var reverse = StringBuffer()
    var marr = mainShape.toString().toCharArray()
    for(i in mainShape.indices){
        forward.append(mainShape[i])
        reverse.insert(0, reverse(mainShape[i]))
    }
    for(i in 0 until num){

        set.add(forward.toString())
        set.add(reverse.toString())

        forward.append(forward.toString().toCharArray()[0])
        reverse.append(reverse.toString().toCharArray()[0])


        forward.deleteCharAt(0)
        reverse.deleteCharAt(0)

    }
    var count = scanner.nextInt()

    for(i in 0 until count){

        var str = StringBuffer()

        for(i in 0 until num){

            str.append(scanner.next())
        }


        if(set.contains(str.toString())){
            cnt++
            for(j in str.indices){

                answer.append(str[j])
                answer.append(" ")
            }
            answer.append("\n")
        }
    }

    println(cnt)
    println(answer.toString())

}

fun reverse(c : Char) : Char{


    if(c=='1'){
        return '3'
    }else if(c== '2'){
        return '4'
    }else if(c== '3'){
        return '1'
    }else{
        return '2'
    }
}

