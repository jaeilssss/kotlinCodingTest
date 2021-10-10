import java.util.*
import kotlin.collections.ArrayList

var visited = booleanArrayOf()
var array : Array<IntArray> = arrayOf()
var strArray :List<String> = listOf()
fun main(){

    var str = readLine()

     strArray = str!!.split(" ")
    array = Array(strArray[0].toInt()){ IntArray(strArray[0].toInt()) }
    visited = BooleanArray(strArray[0].toInt())
    for(i in 0 until strArray[1].toInt()){
        var input = readLine()
        var temp = input!!.split(" ")

      array[temp[0].toInt()-1][temp[1].toInt()-1]= 1
        array[temp[1].toInt()-1][temp[0].toInt()-1]=1

    }


}
fun dfs(v : Int){

    visited[v] =true

    for(i in 0 until strArray[0].toInt()){
        if(array[v][i]!=0 && !visited[i]){
            dfs(i)
        }
    }

}

fun bfs(v : Int){
    val list : LinkedList<Int> = LinkedList()
    list.add(v)
    visited[v]=true

    while (list.isNotEmpty()){
        val now = list.poll()

        for(i in 0 until strArray[0].toInt()){
            if(!visited[i] && array[now][i]!=0){
                list.add(i)
                visited[i]=true

            }
        }
    }

}


