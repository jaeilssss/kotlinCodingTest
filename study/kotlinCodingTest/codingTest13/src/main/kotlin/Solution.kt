
import kotlin.collections.ArrayList

class Solution {
    fun solution(numbers: IntArray): String {
        var answer = "0"

        var temp = arrayOf<String>()
        numbers.forEach {
            temp+=it.toString()
        }

        temp.sortWith(Comparator{ o1, o2 ->
            when{
                o1.length==o2.length -> o2.compareTo(o1)
                else -> (o2+o1).compareTo(o1+o2)
            }
        })

        if(temp[0]=="0"){
            return answer
        }else{
            answer=""
            temp.forEach {
                answer += it
            }
        }
        return answer
    }
}