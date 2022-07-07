
import java.io.BufferedReader
import java.io.InputStreamReader



fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))

    var map = HashMap<String , Int>()

    var arrayList = ArrayList<String>()


    var num = bufferedReader.readLine().toInt()
    var finished= ArrayList<String>()
    var answer= 0
    for(i in 0 until num){
        var str = bufferedReader.readLine()

        map.put(str,i)

        arrayList.add(str)
    }

    for(i in 0 until num){
        var str = bufferedReader.readLine()

        var idx = map.get(str)
        var check =true
        if(idx==0){
            finished.add(str)
        }else{
            for(j in 0 until idx!!){
                if(!finished.contains(arrayList[j])){
                    answer++
                    finished.add(str)
                    check=false
                    break
                }
            }
            if(check) finished.add(str)
        }
    }

    println(answer)
}