class Solution {
    fun solution(s: String): String {
        var answer = ""
        var list = s.split(" ")
        var i = 0
        for(str in list){
            println(str)
            var temp = ""
            for(i in 0 until str.length){

                 if( i==0 || i%2==0){
                     temp += str[i].toUpperCase().toString()
                }else{
                     temp += str[i].toLowerCase().toString()
                }
            }
            if(i==0){
                answer ="$temp"
                i++
            }else{
                answer = "$answer $temp"
            }

        }

        return answer
    }
}

fun main(){
    println(Solution().solution("try hello world"))
}