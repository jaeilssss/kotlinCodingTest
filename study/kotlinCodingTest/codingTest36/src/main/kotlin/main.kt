
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

var graphs : Array<IntArray> = arrayOf()
var visited  : Array<BooleanArray> = arrayOf()
var dx = intArrayOf(-1,0,1,0)
var dy = intArrayOf(0,-1,0,1)
var answer = 0
var count = 0
var startX=-1
var startY = -1
fun main(){

    var size = readLine()!!.toInt()
    var array = IntArray(size)
    var str = readLine()!!.split(" ")
    for(i in 0 until size){
        array[i] = str[i].toInt()
    }
    var count = readLine()!!.toInt()
    for(i in 0 until count){

        var input = readLine()!!.split(" ")
        if (input[0].toInt()==1){
            var temp = input[1].toInt()
            var addNum =2
            while(temp<=size){
                 if(array[temp-1]==1) array[temp-1]=0
                else array[temp-1]=1
                temp  = (input[1].toInt())*addNum
                addNum++
            }
        }else{

            var right = 1
            var left=-1
           if(array[input[1].toInt()-1]==1) array[input[1].toInt()-1] = 0 else array[input[1].toInt()-1] = 1
            while(true){

                if(input[1].toInt()-1+left>=0 && input[1].toInt()-1+right<size){
                    if(array[input[1].toInt()-1+left]==array[input[1].toInt()-1+right]){
                        if(array[input[1].toInt()-1+left]==1) array[input[1].toInt()-1+left]=0 else array[input[1].toInt()-1+left]=1
                        if(array[input[1].toInt()-1+right]==1) array[input[1].toInt()-1+right]=0 else array[input[1].toInt()-1+right]=1
                        right++
                        left--

                    }else{
                        break
                    }
                }else{
                    break
                }
            }

        }


    }
for(i in 0 until size){
    print("${array[i]} ")

}
    println()
}
fun bfs(){

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

