
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList


var arr : Array<Array<IntArray>> = arrayOf()
var idxQueue = LinkedList<Point>()
var checkList = ArrayList<Point>()
var num = listOf<Int>()
var dy = arrayOf(0,1,0,-1)
var dz = arrayOf(-1,0,1,0)
var check = false

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))



     num = bufferedReader.readLine().split(" ").map { it.toInt() }
    var day = 0

    arr = Array(num[2]){ Array(num[1]){ IntArray(num[0]) } }


    for(i in 0 until num[2]){

        for(j in 0 until num[1]){
            var temp = bufferedReader.readLine().split(" ").map { it.toInt() }
            for(k in 0 until num[0]){

                arr[i][j][k]= temp[k]
                if(temp[k]==1){
                    idxQueue.add(Point(i,j,k))
                }else if(temp[k]==0){
                    checkList.add(Point(i,j,k))
                }
            }
        }
    }

    while (idxQueue.isNotEmpty()){
        check = false
        bfs(idxQueue.size)
        if(check) day++

    }
    if(checkList.isEmpty()){
        println(0)
        return
    }
    for(i in checkList.indices){
        var point = checkList.get(i)

        if(arr[point.x][point.y][point.z]==0){
            println("-1")
            return
        }
    }
println(day)



}
class Point(var x  : Int , var y : Int , var z : Int)
fun bfs(size : Int){

    for(k in 0 until size){


        var point = idxQueue.poll()


            if(point.x+1<num[2]){

                if(arr[point.x+1][point.y][point.z]==0){
                    arr[point.x+1][point.y][point.z]=1
                    idxQueue.add(Point(point.x+1,point.y,point.z))
                    check = true
                }
            }
            if(point.x-1>=0){
                if(arr[point.x-1][point.y][point.z]==0){
                    arr[point.x-1][point.y][point.z]=1
                    idxQueue.add(Point(point.x-1,point.y,point.z))
                    check = true
                }
            }
            for(i in 0 until 4){

                var tempY = point.y+dy[i]
                var tempZ = point.z+dz[i]

            if(tempY>=0 &&tempZ>=0 && tempY<num[1] && tempZ<num[0])
                if(arr[point.x][tempY][tempZ]==0){
                    arr[point.x][tempY][tempZ]=1
                    idxQueue.add(Point(point.x,tempY,tempZ))
                    check = true
                }

            }

    }



}