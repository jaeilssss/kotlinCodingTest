import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Math.round

val br = BufferedReader(InputStreamReader(System.`in`))
fun main()=with(br){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val num = readLine()!!.toInt()
    var list = mutableListOf<Int>()
    var key = HashMap<Int,Int>()
    for(i in 0 until num){
        val go = readLine()!!.toInt()
        list.add(go)
        if(!key.containsKey(go)){
            key[go]=0
        }
        key[go]=key[go]!!+1
    }
    //println(key)
    var list3 = key.toList().sortedWith(Comparator { d1, d2 ->
        d1.first - d2.first
    })
    var list2 = list3.sortedWith(Comparator { d1, d2 ->
        d2.second - d1.second
    })
    //println(list2)
    list.sort()
    //println(list)
    // println(key)
    bw.write("${round(list.average())}\n")
    bw.write("${list[num/2]}\n")
    if(num==1) {
        bw.write("${list2[0].first}\n")
    }
    else {
        if (list2[0].second > list2[1].second) {
            bw.write("${list2[0].first}\n")
        } else {
            bw.write("${list2[1].first}\n")
        }
    }
    bw.write("${list.maxByOrNull { it }!! - list.minByOrNull { it }!!}\n")
    bw.flush()
    bw.close()
}
