import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(System.`in`))


    var num = bufferedReader.readLine().split(" ").map { it.toInt() }

    var list = ArrayList<Int>()

    var str = bufferedReader.readLine().split(" ").map { it.toInt() }
    var sum = 0
    for(j in 0 until str.size-1){
        var n = str[j+1]-str[j]
        list.add(n)
    }

    list.sort()

    for(i in 0 until num[0]-num[1]){
        sum +=list[i]
    }

    println(sum)
}
