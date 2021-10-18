
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

fun main(){
var array = readLine()!!.split(" ").map { it.toInt() }
    var newArray : IntArray = array.toIntArray()
    array = array.sorted()
var left = 0
    var right = 1
while (true){
    if(right==5){
        left = 0
        right=1
    }
    if(newArray[left]>newArray[right]){
        var check = true
        var temp = newArray[left]
        newArray[left] = newArray[right]
        newArray[right] = temp
        for(i in 0..4){
            if(newArray[i]!=array[i]){
                check = false
            }
            print("${newArray[i]} ")
        }
        println()
        if(check){
            break
        }
    }
    left++
    right++

}

}


