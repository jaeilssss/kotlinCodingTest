import kotlin.math.abs
val bre = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){

    var n = bre.readLine().toInt()
    var answer = ArrayList<String>()
    for(i in 0 until  n){
        var count = bre.readLine().toInt()
        var str = bre.readLine().split(" ")
        var temp =""
        for(j in 0 until count){
            if(j==0){
                temp = str[j]
            }else{
                if(temp.toCharArray()[0].toString()>=str[j]){
                    temp = "${str[j]}${temp}"
                }else{
                    temp = "${temp}${str[j]}"
                }
            }

        }

        answer.add(temp)
    }

    for(i in answer.indices){
        println(answer[i])
    }
}






