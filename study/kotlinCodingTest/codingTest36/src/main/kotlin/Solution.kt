class Solution {
    private fun lcm(a: Int, b: Int) : Int{

        return a*b/gcm(a, b)
    }

    private fun gcm(a: Int, b: Int) : Int{
        var num =a
        var num2 = b
        while (num2!=0){
            val r = num%num2

            num=num2
            num2 = r
        }
        return num
    }
    fun solution(arr: IntArray): Int {
        var answer=  arr[0]
        for(i in 1 until arr.size){

            answer = lcm(answer, arr[i])
        }


        return answer
    }
}


fun main(){

println(Solution().solution(intArrayOf(1,2,3)))

}