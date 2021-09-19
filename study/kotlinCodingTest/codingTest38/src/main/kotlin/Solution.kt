class Solution {
    companion object{
        lateinit var memo : IntArray
    }
    fun solution(n: Int): Int {
        var answer = 0
        memo = IntArray(n+1)
        answer = fibonacci(n)

        return answer
    }

    fun fibonacci(num: Int) : Int{
        return if(num==0){
            0
        } else if(num<=2){
            1
        }else if(num==3){
            2
        }else if(num==5){
            5
        } else{
            if(memo[num]!=0){
                memo[num]
            }else{
                memo[num] = (fibonacci(num-1)+fibonacci(num-2))%1234567
                memo[num]
            }
        }
    }
}



fun main(){
        println(Solution().solution(3))
}