import kotlin.math.min

fun main(){
    var answer = 0
   var str = readLine()
    var array = str!!.split(" ")
    var sub1 = ArrayList<Int>()
    var sub2 = ArrayList<Int>()
    var map = HashMap<Int,Boolean>()
    for(i in 0 until array[0].toInt()){
        var question = readLine()
        var questionArray = question!!.split(" ")
        sub1.add(questionArray[0].toInt())
        sub2.add(questionArray[1].toInt())
    }
    sub1.sortDescending()
    sub2.sortDescending()
    for(i in sub2.indices ){
        if(map.size==array[2].toInt()){
            break
        }
        if(map.size<=array[2].toInt() && sub2[i].toInt()<=array[1].toInt()){
            answer +=140
            map.put(i,true)
        }
    }
    for(i in 0 until array[0].toInt()){
        if(map.size==array[2].toInt()){
            break
        }
        if(sub1[i].toInt()<=array[1].toInt() && map.containsKey(i).not()){
            answer +=100
            map.put(i,true)
        }

    }
println(answer)
}