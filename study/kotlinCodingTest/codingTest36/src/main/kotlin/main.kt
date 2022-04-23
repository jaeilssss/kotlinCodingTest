
import java.util.*
fun main()  {


    var scanner = Scanner(System.`in`)

    var firstStr = scanner.nextLine()
    var secondStr = scanner.nextLine()
    var index= 0
    var answer =0
    while (index+secondStr.length<=firstStr.length){
        if(firstStr.substring(index,index+secondStr.length).equals(secondStr)){
            answer++
            index +=secondStr.length
        }else{
            index++
        }


    }

    println(answer)
}