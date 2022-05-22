
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))

    var num = bufferedReader.readLine().toInt()

    var chars = bufferedReader.readLine().toCharArray()

    var bCount = 0
    var rCount = 0
    for(i in 0 until num){

        var c = chars[i]
        if(i==0){
            if(chars[i]=='B') bCount++
            else rCount++
        }else{

            if(c==chars[i-1]) continue
            else{
                if(c=='B') bCount++
                else rCount++
            }
        }
    }

    if(bCount>=rCount) println(rCount+1)
    else println(bCount+1)
}

