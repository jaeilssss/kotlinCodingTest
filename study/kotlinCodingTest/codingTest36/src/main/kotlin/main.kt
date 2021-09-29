import kotlin.math.min

fun main(){
    var n = readLine()?.toInt()
    var num = n!!
    var answer = 0
    while (true){
        if(num%5==0){
            if(num==0){
                println(answer)
            }else{
                println(answer+num/5)
            }
            break
        }else if(num<0){
            println(-1)
            break
        }
        num -=3
        answer++

    }
}