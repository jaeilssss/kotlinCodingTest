
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
var graphs : Array<ArrayList<Int>> = arrayOf()
var answer = 0
var count = 0
var friendNum =0
var check  = false
fun main(){
var str = readLine()!!.split(" ").map { it.toInt() }
    graphs = Array(str[0]){ ArrayList() }
    friendNum = str[1]
    for(i in 0 until str[0]){
        var temp = readLine()!!.toInt()
        graphs[i].add(temp)
    }
    dfs(0)

}

fun dfs(v : Int){
    count++

    if(v==friendNum && !check){

        println(answer)
        check= true
        return
    }
    if(count==graphs.size+1){
        if(!check){
            println(-1)
        }
        return
    }
    for( i in 0 until graphs[v].size){
        answer++
        var data = graphs[v].get(i)
        if(check){
            break
        }else{
            dfs(data)
        }

    }
}


