import java.util.*
import kotlin.collections.HashMap

class Solution {

    var visited :IntArray = intArrayOf()
    var arr  : Array<HashMap<Int,Int>> = arrayOf()
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 1


        visited = IntArray(N+1){-1}
        arr = Array(N+1){ HashMap() }

        for(i in road.indices){
            var startIndex = road[i][0]
            var endIndex = road[i][1]
            var distance = road[i][2]

            if(arr[startIndex].containsKey(endIndex)){

                if(arr[startIndex][endIndex]!! >distance){
                    arr[startIndex][endIndex] = distance
                    arr[endIndex][startIndex] = distance
                }
            }else{
                arr[startIndex][endIndex] = distance
                arr[endIndex][startIndex] = distance
            }


        }
        search(1)
        for(i in 2 ..N){
            if(visited[i]<=k && visited[i]!=-1){
                answer++
            }
        }
        return answer
    }

    fun search(index : Int ){
    visited[1]=0
    var queue = LinkedList<Int>()
        queue.add(index)
        while (!queue.isEmpty()){

            var i = queue.poll()

            for(key in arr[i].keys){
                var dist = arr[i][key]

                if(visited[key]==-1){
                    queue.add(key)
                    visited[key] = dist!!+visited[i]
                }else if(visited[key] >visited[i]+dist!!){
                    visited[key] = visited[i]+dist
                    queue.add(key)
                }
            }
        }
    }
}

fun main(){
    var solution = Solution()

    var answer = solution.solution(5,
    arrayOf(intArrayOf(1,2,1), intArrayOf(2,3,3), intArrayOf(5,2,2), intArrayOf(1,4,2),
    intArrayOf(5,3,1), intArrayOf(5,4,2)),3)
    println(answer)
}