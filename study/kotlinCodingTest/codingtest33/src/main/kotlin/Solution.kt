class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)
        var index =0
        for(i in 1..n){
            answer[index++]=(x.toLong()*i).toLong()
        }
        return answer
    }
}

fun main(){
    var data = Solution().solution(10000000,1000)
    for(i in data.indices){
        println(data[i])
    }

}