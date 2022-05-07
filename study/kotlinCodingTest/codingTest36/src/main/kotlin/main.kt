
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Node(
    var start : Int,
    var end : Int,
    var dst : Int
){
}

var minDist = Integer.MAX_VALUE
var node  : HashMap<Int , ArrayList<Node>> = HashMap()

var d : Int = 0
var n : Int = 0
fun main()  {

    var scanner = Scanner(System.`in`)

    n = scanner.nextInt()
    d = scanner.nextInt()

    for(i in 0 until n){
        var start = scanner.nextInt()
        var end = scanner.nextInt()
        var dist = scanner.nextInt()

        if(node.containsKey(start)){

            var list = node.get(start)
            list!!.add(Node(start,end,dist))
            node.put(start,list)

        }else{
            var list = ArrayList<Node>()
                list.add(Node(start,end,dist))
            node.put(start,list)
        }
    }



    search(0,0)
    println(minDist)
}


fun search(start : Int, totalDist : Int){

    var startIdx = start
    var distance = totalDist
    var loop = true
    while (loop){

        if(startIdx>=d){
            if(startIdx==d){
                minDist = Math.min(minDist,distance)

            }
            loop = false
        } else {
            if(node.containsKey(startIdx)){

                var list = node.get(startIdx)


                for(i in list!!.indices){

                    search(list.get(i).end,distance+list.get(i).dst)
                }
            }
                startIdx++
                distance++

        }
    }

}
