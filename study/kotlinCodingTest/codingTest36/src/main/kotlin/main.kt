
import java.util.*
import kotlin.collections.ArrayList

var graphs : Array<IntArray> = arrayOf()
var visited  : Array<BooleanArray> = arrayOf()
var dx = intArrayOf(-1,0,1,0)
var dy = intArrayOf(0,-1,0,1)
var answer = 0
var count = 0
fun main(){
  var size = readLine()!!.toInt()
    var list = ArrayList<Int>()
    graphs = Array(size+2){ IntArray(size+2) }
    visited = Array(size+2){ BooleanArray(size+2) }
    for(i in 1 until size+1){
        var input = readLine()!!.toCharArray()

        for(j in 1 until size+1){

            graphs[i][j]=Integer.parseInt(input[j-1].toString())
        }
    }

    for(i in 1 until size+1){
        for(j in 1 until size+1){
            if(!visited[i][j] && graphs[i][j]==1){
                answer=0
                dfs(i,j)
                visited[i][j]=true
                count++
                list.add(answer)
            }
        }
    }

    list.sort()
    println(count)
    for(i in list.indices){

        println(list[i])
    }


}
fun dfs(x : Int , y : Int){

    answer++
    visited[x][y] = true
    for(i in 0..3){

        var tempX = x+dx[i]
        var tempY = y+dy[i]
        if(!visited[tempX][tempY] && graphs[tempX][tempY]==1){
            dfs(tempX,tempY)
        }

    }
}

