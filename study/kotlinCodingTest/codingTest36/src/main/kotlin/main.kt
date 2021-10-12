import java.util.*

var visited : Array<BooleanArray> = arrayOf()

var graphs : Array<IntArray> = arrayOf()
var dx = intArrayOf(-1,0,1,0)
var dy = intArrayOf(0,-1,0,1)

class Pointer( var x : Int = 0,
               var y : Int = 0)

fun main() {

    var temp = readLine()

    var array = temp!!.split(" ").map { it.toInt() }

    visited = Array(array[0]+2){ BooleanArray(array[1]+2) }
    graphs = Array(array[0]+2){ IntArray(array[1]+2) }


    for(i in 1 .. array[0]){
        var temp  = readLine()!!.toCharArray()

        for(j in 1 .. array[1]){
            graphs[i][j] = Integer.parseInt(temp.get(j-1).toString())
        }
    }

    bfs(1,1)

    println(graphs[array[0]][array[1]])
}

fun bfs(x : Int, y : Int){
    var queue = LinkedList<Pointer>()
    queue.add(Pointer(x,y))
    visited[x][y]=true
    while (queue.isNotEmpty()){
        var pointer = queue.poll()
        for(i in 0 until 4){

            var tempX = pointer.x+dx[i]
            var tempY = pointer.y+dy[i]

            if(graphs[tempX][tempY]!=0 && !visited[tempX][tempY]){
                visited[tempX][tempY] =true
                graphs[tempX][tempY] = graphs[pointer.x][pointer.y]+1
                queue.add(Pointer(tempX,tempY))
            }
        }
    }
}