import java.lang.Math.sqrt

class Solution {
    fun solution(n: Long): Long {
        val a = sqrt(n.toDouble()).toLong()
        return if (a * a == n) (a + 1)*(a + 1) else -1
    }
}
