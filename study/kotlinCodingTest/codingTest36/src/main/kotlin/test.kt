import java.util.*

var arr : Array<IntArray> = arrayOf()
var dist : Array<IntArray> = arrayOf()
var visit : Array<BooleanArray> = arrayOf()
var dir  = arrayOf(intArrayOf(0,1), intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,-1))
fun main(args: Array<String>){


    var scanner = Scanner(System.`in`)

    var num = scanner.nextInt()

    arr = Array(num+1){ IntArray(num+1) }
    dist = Array(num+1){ IntArray(num+1){Int.MAX_VALUE} }

    visit = Array(num+1){ BooleanArray(num+1) }

    for(i in 1 until num+1){

        var str = scanner.next()

        for(j in str.indices){

            arr[i][j+1] = str[j].toString().toInt()
        }
    }

    bfs(num)

}

private fun bfs(num: Int){

    var queue = LinkedList<Point>()

    queue.add(Point(1,1))

    visit[1][1]  = true
    dist[1][1] = 0
    while(!queue.isEmpty()){
        var point  : Point = queue.poll()
        visit[point.x][point.y] = true
        if(point.x==num&&
                point.y==num){
            continue
        }
        for(i in 0 until 4){

            var tempX = point.x+dir[i][0]
            var tempY = point.y+dir[i][1]

            if(tempX in 1..num &&
                    tempY in 1.. num ){

                if(arr[tempX][tempY]==1){
                    if(dist[tempX][tempY] >dist[point.x][point.y]){
                        queue.add(Point(tempX,tempY))
                        dist[tempX][tempY] = dist[point.x][point.y]
                    }

                }else{
                    if(dist[tempX][tempY] >dist[point.x][point.y]+1){
                        queue.add(Point(tempX,tempY))
                        dist[tempX][tempY] = dist[point.x][point.y]+1
                    }
                }
            }
        }
    }

    println(dist[num][num])
}

class Point(var x : Int , var y : Int)








