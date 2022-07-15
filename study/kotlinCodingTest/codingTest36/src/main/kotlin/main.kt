import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))


    var num = bufferedReader.readLine().toInt()
    var dp = IntArray(num+1)
    dp[1] = 1
    dp[2] = 2
    if(num==1){
        println("1")
    }else if(num==2){
        println("2")
    }else{
        for(i in 3 ..num){
            dp[i] = (dp[i-1]+dp[i-2])%10007
        }
        println(dp[num])
    }

}

