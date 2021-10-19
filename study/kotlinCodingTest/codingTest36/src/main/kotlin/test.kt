import kotlin.math.min
var array :Array<CharArray> = arrayOf()
fun main(){
    var size = readLine()!!.toInt()
    var max = 0
    array = Array(size){ CharArray(size) }

    for(i in 0 until size){
        var str = readLine()!!.toCharArray()

        for(j in 0 until size){
            array[i][j]=str[j]
        }
    }

    for(i in 0 until size){

        for(j in 0 until size){

        }
    }

}
