import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(){


    var num = readLine()!!.toInt()
    var map = HashMap<String,Int>()

    for(i in 0 until num){
        var name = readLine()!!.split(".")

        if(map.containsKey(name[1])){
            map.put(name[1], map.get(name[1])!!+1)
        }else{
            map.put(name[1],1)
        }
    }
    var array = map.keys
    var list = array.sorted()

    for(i in 0 until list.size){

        println("${list[i]} ${map.get(list[i])}")
    }


}






