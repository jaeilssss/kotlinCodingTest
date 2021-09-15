import java.lang.Integer.min
import java.lang.Math.max

class Solution {
    fun solution(n: Int, m: Int): IntArray {
        return intArrayOf(gcm(n, m), lcm(n, m))
    }

    // 최대공약수
    fun gcm(a: Int, b: Int): Int {
        var maximum = max(a, b)
        var minimum = min(a, b)

        if (minimum == 0) {
            return maximum
        } else {
            return gcm(minimum, maximum % minimum)
        }
    }


    //최소공배수수
    fun lcm(a: Int, b: Int): Int =
        (a * b) / gcm(a, b)
}

fun main(){
    var result = Solution().solution(0,20)

    for(i in result.indices){
        println(result[i])
    }
}
