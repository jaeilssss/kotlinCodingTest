
import java.util.*
import kotlin.collections.ArrayList

var arr : Array<CharArray> = arrayOf()
var visited : Array<BooleanArray> = arrayOf()
var answer = Int.MIN_VALUE
var n : Int =0
var m =0
var dir = arrayOf(arrayOf(1,0), arrayOf(0,1), arrayOf(-1,0), arrayOf(0,-1))
fun main() = with(System.out.bufferedWriter()) {

    var list= ArrayList<Point>()

    var scanner = Scanner(System.`in`)
     n = scanner.nextInt()
     m = scanner.nextInt()
    arr = Array(n+1){ CharArray(m+1) }
    visited = Array(n+1){ BooleanArray(m+1) }

    for(i in 0 until n){
        var carr = scanner.next().toCharArray()
        for(j in 0 until m){

            arr[i+1][j+1] = carr[j]

            if(arr[i+1][j+1]=='L'){
                list.add(Point(i+1,j+1,0))
            }
        }
    }

    for(i in list.indices){
        visited = Array(n+1){ BooleanArray(m+1) }

        var point = list[i]

        search(point.x,point.y)
    }

    println(answer)
}

fun search(x : Int, y : Int){



    var queue = LinkedList<Point>()

    queue.add(Point(x,y,0))
    visited[x][y] = true
    var count =0
    while (!queue.isEmpty()){
        count++
        var point = queue.poll()
        var check = false


            for(i in dir.indices){
                var tempX  =point.x+dir[i][0]
                var tempY = point.y+dir[i][1]

                if(tempX in 1 until n+1 &&
                    tempY in 1 until m+1){

                    if(!visited[tempX][tempY] && arr[tempX][tempY]=='L'){
                        visited[tempX][tempY] = true
                        queue.add(Point(tempX,tempY,point.dist+1))

                        check = true
                    }
                }
            }

        if(!check)                         answer = Math.max(answer,point.dist)


    }


}



class Point(var x : Int , var y : Int , var dist : Int)











