
import java.io.BufferedReader
import java.io.InputStreamReader
var list = ArrayList<BaseBall>()
fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))


    var count= bufferedReader.readLine().toInt()
    var anwwer = HashSet<String>()



    for(i in 0 until count){
        var str = bufferedReader.readLine().split(" ").map { it.toInt() }

        var array = IntArray(3)

        array[0] = str[0].toString().toCharArray()[0].toString().toInt()
        array[1] = str[0].toString().toCharArray()[1].toString().toInt()
        array[2] = str[0].toString().toCharArray()[2].toString().toInt()
        list.add(BaseBall(array,str[1],str[2]))

    }


    for(num in 123 .. 987){
        var arr = num.toString().toCharArray()

        var num1 = arr[0].toString().toInt()
        var num2 = arr[1].toString().toInt()
        var num3 = arr[2].toString().toInt()

        if(num1==num2 || num1==num3 || num2==num3|| num1==0 || num2==0 || num3==0){
            continue
        }else{
            if(check(intArrayOf(num1,num2,num3))){
                anwwer.add("${num1}${num2}${num3}")
            }
        }


    }
    println(anwwer.size)
}


class BaseBall(var data : IntArray ,var strike : Int , var Ball : Int)

fun check(input : IntArray) : Boolean{

    var result = true
    for(i in list.indices){
        var baseBall : BaseBall = list.get(i)
        var strikeCount = 0
        var ballCount = 0

        if(input[0]==baseBall.data[0]){
            strikeCount++
        }
        if(input[1]==baseBall.data[1]){
            strikeCount++
        }
        if(input[2]==baseBall.data[2]){
            strikeCount++
        }

        if(input[0]==baseBall.data[1] || input[0]==baseBall.data[2]){
            ballCount++
        }
        if(input[1]==baseBall.data[0] || input[1]==baseBall.data[2]){
            ballCount++
        }
        if(input[2]==baseBall.data[1] || input[2]==baseBall.data[0]){
            ballCount++
        }

        if(ballCount !=baseBall.Ball || strikeCount != baseBall.strike){
            return false
        }
    }
    return result
}

