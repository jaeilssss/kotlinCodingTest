
import java.util.*
import kotlin.collections.ArrayList

var graphs : Array<IntArray> = arrayOf()
var visited  : Array<BooleanArray> = arrayOf()
var dx = intArrayOf(-1,0,1,0)
var dy = intArrayOf(0,-1,0,1)
var answer = 0
var count = 0
fun main(){
  var num = readLine()!!.toInt()
    var list = ArrayList<Int>()
    for(i in 0 until num){
        answer=0
        var str = readLine()!!.split(" ")
        graphs = Array(str[0].toInt()+2){ IntArray(str[1].toInt()+2) }
        visited = Array(str[0].toInt()+2){ BooleanArray(str[1].toInt()+2) }
        for(j in 0 until str[2].toInt()){
            var input = readLine()!!.split(" ")
            graphs[input[0].toInt()+1][input[1].toInt()+1]=1
        }

        for(a in 1 until str[0].toInt()+1){
            for(m in 1 until str[1].toInt()+1){
                if(!visited[a][m] && graphs[a][m]==1){
                    dfs(a,m)
                    answer++
                }
            }
        }
        list.add(answer)
    }
for(i in list.indices){
    println(list.get(i))
}



}
fun dfs(x : Int , y : Int){


    visited[x][y] = true
    for(i in 0..3){

        var tempX = x+dx[i]
        var tempY = y+dy[i]
        if(!visited[tempX][tempY] && graphs[tempX][tempY]==1){
            dfs(tempX,tempY)
        }

    }
}

