
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))

    var num = bufferedReader.readLine().toInt()
    var numList = bufferedReader.readLine().split(" ").map { it.toInt() }


  var list =  numList.sortedDescending()
    var answer = 0
    var max = list[0]
    for(i in 1 until list.size){
        answer += max+list[i]

    }
    println(answer)

}

