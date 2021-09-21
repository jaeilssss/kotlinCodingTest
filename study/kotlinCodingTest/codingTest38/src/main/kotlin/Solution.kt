class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = IntArray(2)

        var sum = brown+yellow

        for(i in 2..sum){
            if(sum%i==0){
                if(sum/i<=i){
                    answer[0]=i
                    answer[1]=sum/i
                    break
                }
            }
        }
        return answer
    }
}




fun main(){
    var data = Solution().solution(5000,2000000)
    println(data[0])
    println(data[1])
}