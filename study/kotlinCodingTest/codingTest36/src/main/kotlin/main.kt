import kotlin.math.abs
val bre = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){

   var strArray = bre.readLine().split(" ")

    var answer = Integer.MAX_VALUE

    for(i in 0.. (strArray[1].length - strArray[0].length)){
        var count =0
        for(j in strArray[0].indices){
            if(strArray[1].toCharArray()[j+i]!=strArray[0].toCharArray()[j]){
                count++
            }

        }

        answer = Math.min(count,answer)
    }

    println(answer)
}






