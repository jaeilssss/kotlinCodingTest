
import java.util.*

var graphs :Array<CharArray> = arrayOf()
fun main(){

    var input = readLine()!!.split(" ").map { it.toInt() }
    graphs = Array(input[0]){ CharArray(input[1]) }
    var count = 0
    var num=0
    for(i in 0 until input[0]){
        var str = readLine()!!.toCharArray()
        for(j in 0 until input[1]){
            graphs[i][j]=str[j]
        }
    }
    for(i in 0 until input[0]){

        for(j in 0 until input[1]){
            if(graphs[i][j].equals('-')){
                    if(count==0){
                        num++
                        count=1
                    }
            }else{
                count=0
            }

        }
        count=0
    }
    for(j in 0 until input[1]){
        for(i in 0 until input[0]){
            if(graphs[i][j].equals('|')){
                if(count==0){
                    count=1
                    num++
                }
            }else{
                count=0
            }
        }
        count=0
    }
    println(num)
}
