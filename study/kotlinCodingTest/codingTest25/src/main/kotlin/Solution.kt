import java.util.*
import kotlin.collections.ArrayList

class Solution {
    fun solution(n: Long): Long {
        var list = ArrayList<Char>()
        var str = n.toString()

        for(i in str.indices){
            list.add(str[i])
        }
        str=""
        list.sortDescending()
        for(i in list.indices){
            str += list[i]
        }
        return str.toLong()
    }
}

fun main(){
    var solution = Solution()
    solution.solution(1234)
}