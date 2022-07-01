import java.util.*
import kotlin.collections.HashMap

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0

        var heap = PriorityQueue<IntArray>()


        return answer
    }

    fun dfs(){

    }
}

fun main(){
    var heap = PriorityQueue<HashMap<Int,Int>>()

    var map = HashMap<Int,Int>()
    map.put(100,10)

    heap.add(map)
    map.remove(100)
    map.put(1,1)
    heap.add(map)

    heap.forEach {
        var keys = it.keys.toList()
        println(keys[0])
    }
}