import java.io.BufferedReader
import java.io.InputStreamReader

val br = BufferedReader(InputStreamReader(System.`in`))
var visited  : BooleanArray = booleanArrayOf()
var num = listOf<Int>()
fun main()=with(br){


     num = br.readLine().split(" ").map { it.toInt() }

    visited = BooleanArray(num[0]+1)



    dfs(0,"")

}

fun dfs(count : Int , str : String){

    if(count==num[1]){

        println(str)
        return
    }
    for(i in 1 .. num[0]){

        if(str.isEmpty()){
            if(!visited[i]){
                visited[i]=true
                dfs(count+1 ,"$i")
                visited[i] = false
            }
        }else{
            if(!visited[i]){
                visited[i]=true
                dfs(count+1 ,"$str $i")
                visited[i] = false
            }
        }

    }
}

