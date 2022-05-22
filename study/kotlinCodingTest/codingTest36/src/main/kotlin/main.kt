
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))

    var chars = bufferedReader.readLine().toCharArray()

    var stack = Stack<Int>()

    var answer = 0
    var check = false
    var lastNum  =0
    stack.push(0)
    for(i in chars.indices){

        var c = chars[i]

            if(c=='H'){
            var num = stack.pop()
                stack.push(num+1)
                lastNum = 1
            }else if(c=='C'){
                var num = stack.pop()
                stack.push(num+12)
                lastNum=12
            }else if(c=='O'){
                var num = stack.pop()
                stack.push(num+16)
                lastNum = 16
            }else if(c=='('){
                stack.push(0)
            }else if(c==')'){
                var num1 = stack.pop()
                lastNum = num1
                var num2 = stack.pop()
                stack.push(num1+num2)
            }else{
                var num = chars[i].toString().toInt()
                for(i in 1 until num){
                    var temp = stack.pop()
                    stack.push(temp+lastNum)
                }
            }

    }

    println(stack.pop())

}

