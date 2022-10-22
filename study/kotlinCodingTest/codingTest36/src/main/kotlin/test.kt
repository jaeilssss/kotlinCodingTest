
import java.util.*

var arr : Array<IntArray> = arrayOf()
var d = arrayOf(arrayOf(0,-1), arrayOf(0,1), arrayOf(1,0), arrayOf(-1,0))
var visited  : Array<BooleanArray> = arrayOf()
var dist = Int.MAX_VALUE
fun main() = with(System.out.bufferedWriter()){

    var scanner = Scanner(System.`in`)

    var N  = scanner.nextInt()
    var M = scanner.nextInt()

    visited = Array(N+1){ BooleanArray(M+1) }

    arr = Array(N+1){ IntArray(M+1) }


    for(i in 1 .. N){

        var str = scanner.next().toCharArray()

        for(j in 0 until  M){
            arr[i][j+1] = str[j].toString().toInt()

        }
    }

    search(N,M)


    if(dist==Int.MAX_VALUE){
        println(-1)
    }


}

fun search(N : Int , M : Int){
    var queue = LinkedList<Point>()

    queue.add(Point(1,1,1, false))

    visited[1][1] = true
    while (!queue.isEmpty()){

        var point = queue.poll()
        if(point.x==N && point.y==M){
            println(point.dist)
            dist = point.dist
            return
        }
        for(i in d.indices){

            var x = point.x +d[i][0]
            var y = point.y + d[i][1]


            if(x in 1..N && y in 1..M){

                if(!visited[x][y] && arr[x][y]==0){
                    queue.add(Point(x,y,point.dist+1 , point.check))
                    visited[x][y] = true

                }else if(!visited[x][y] && arr[x][y]==1){
                    if(!point.check){
                        queue.add(Point(x,y,point.dist+1 , true))
                        visited[x][y] = true
                    }
                }
            }
        }

    }
}



class Point(var x : Int , var y : Int , var dist : Int, var check : Boolean)











