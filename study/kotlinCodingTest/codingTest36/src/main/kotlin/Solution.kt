import java.lang.StringBuilder

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0


        var str = converter(k , n)
        var startIndex = -1
        for(i in str.indices){

            if(startIndex ==-1 && ! str.substring(i,i+1).equals("0")){
                startIndex = i

                if(i==str.length-1 && !str.substring(i,i+1).equals("0")){
                    if(startIndex==-1){
                        startIndex = i
                    }
                    var num = str.substring(startIndex,i+1)
                    if(isPrime(num.toLong())){
                        answer++
                    }
                }
            } else if(startIndex != -1 && str.substring(i,i+1).equals("0")){


                var num = str.substring(startIndex,i)
                if(isPrime(num.toLong())){
                    answer++
                }
                startIndex = -1
            }else if(i==str.length-1 && !str.substring(i,i+1).equals("0")){
                if(startIndex==-1){
                    startIndex = i
                }
                var num = str.substring(startIndex,i+1)
                if(isPrime(num.toLong())){
                    answer++
                }


            }
        }
        return answer
    }

    fun converter(digits : Int , num : Int) : String {
        var number = num

        val  sb = StringBuilder()

        if(number==0) return "0"

        while (number!=0){
            val remain = number % digits

            if(remain >9){
                sb.insert(0,(remain+55).toChar())
            }else{
                sb.insert(0,remain)
            }

            number /= digits
        }

        return sb.toString()
    }

    fun isPrime(num : Long) : Boolean{


        if(num<=1) return false
        for(i in 2 ..Math.sqrt(num.toDouble()).toInt()){
            if((num%i).toInt()==0) return false
        }
        return true
    }
}

fun main(){
    println(Solution().solution(524287,2))
}