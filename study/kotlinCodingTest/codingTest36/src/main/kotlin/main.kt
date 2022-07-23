import java.io.BufferedReader
import java.io.InputStreamReader
fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))

    var num = bufferedReader.readLine().split(" ")
    var eightCount=0
    if(num[0].length==num[1].length){
        if(num[0]==num[1]){
            for(i in num[0].indices){
                if(num[0].toCharArray()[i]=='8' &&
                    num[0].toCharArray()[i]==num[1].toCharArray()[i]){
                    eightCount++
                }
            }
        }else{
            for(i in num[0].indices){
                if(num[0].toCharArray()[i]==num[1].toCharArray()[i]){
                   if(num[0].toCharArray()[i]=='8') eightCount++
                }else{
                    break
                }
            }
        }
    }
        println(eightCount)
}
