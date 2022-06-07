
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))

   var num = bufferedReader.readLine().split(" ").map { it.toInt() }
    var arr = Array<CharArray>(num[0]){ CharArray(num[1]) }
    var list = ArrayList<String>()
    for(i in 0 until num[0]){
        var temp = bufferedReader.readLine().toCharArray()

        for(j in 0 until num[1]){
            arr[i][j] = temp[j]
        }
    }

    for(i in 0 until num[0]){
        var str =""
        for(j in 0 until num[1]){
            if(arr[i][j]=='#') break
           else str +=arr[i][j].toString()
        }
        if(str!="" && str.length>=2) list.add(str)
    }

    for(i in 0 until num[1]){
        var str = ""
        for(j in 0 until num[0]){
          if(arr[j][i]=='#') break
           else str+= arr[j][i].toString()
        }
        if(str!="" && str.length>=2) list.add(str)
    }

    list.sort()

    println(list[0])

}

