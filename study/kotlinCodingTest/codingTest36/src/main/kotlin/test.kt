import sun.management.counter.LongCounter
import java.util.*
import kotlin.collections.ArrayList

fun main(){

    var scanner = Scanner(System.`in`)

    var input1 = scanner.next()

    var input2 = scanner.next()



  input1=  input1.replace("IV","A")
    input1= input1.replace("IX","B")
    input1= input1.replace("XL","G")
    input1= input1.replace("XC","R")
    input1= input1.replace("CD","E")
    input1= input1.replace("CM","F")


    input2=  input2.replace("IV","A")
    input2= input2.replace("IX","B")
    input2=input2.replace("XL","G")
    input2=input2.replace("XC","R")
    input2=input2.replace("CD","E")
    input2=input2.replace("CM","F")

    var sum = changeNumber(input1.toCharArray())+changeNumber(input2.toCharArray())
    println(sum)

    println(changeRoma(sum))



}

fun changeNumber(carr : CharArray) : Int{

    var num = 0

    var vCount = 0
    var lCount = 0
    var dCount = 0
    for(i in carr.indices){
        if(carr[i]=='M'){
            num += 1000
        }else if(carr[i]=='D' && dCount==0){
            num += 500
            dCount++
        }else if(carr[i]=='C'){
            num += 100
        }else if(carr[i]=='L' && lCount==0){
            num += 50
            lCount++
        }else if(carr[i]=='X'){
            num += 10
        }else if(carr[i]=='V' &&vCount==0){
            num += 5
            vCount++
        }else if(carr[i]=='I'){
            num += 1

        }else if(carr[i]=='A'){
            num += 4
        }else if(carr[i]=='B'){
            num += 9
        }else if(carr[i]=='G'){
            num += 40

        }else if(carr[i]=='R'){
            num += 90
        }else if(carr[i]=='E'){
            num += 400
        }else if(carr[i]=='F'){
            num += 900

        }
    }

    return num
}

fun changeRoma(num : Int):String{

    var temp = num
    var str = StringBuffer()
    while (temp!=0){
        if(temp>=1000){
            temp -= 1000
            str.append("M")
        }else if(temp>=900){
            temp -=900
            str.append("CM")
        } else if(temp>=500){
            temp -=500
            str.append("D")
        }else if(temp>=400){
            temp -=400
            str.append("CD")
        } else if(temp>=100){
            temp -=100
            str.append("C")
        }else if(temp>=90){
            temp -= 90
            str.append("XC")
        } else if(temp>=50){
            temp -=50
            str.append("L")
        }else if(temp>=40){
            temp -=40
            str.append("XL")
        } else if(temp>=10){
            temp-=10
            str.append("X")
        }else if(temp>=9){
            temp -= 9
            str.append("IX")
        } else if(temp>=5){
            temp -=5
            str.append("V")
        }else if(temp>=4){
            temp -=4
            str.append("IV")
        }
        else if(temp>=1){
            temp -= 1
            str.append("I")
        }


    }
    return str.toString()
}










