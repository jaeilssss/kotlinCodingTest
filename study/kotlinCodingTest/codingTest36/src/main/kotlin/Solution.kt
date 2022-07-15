class Solution {
    var list = ArrayList<Int>()
    var max = ""
    var visited  : BooleanArray = booleanArrayOf()
    fun solution(numbers: IntArray): String {
        var answer = ""

        visited = BooleanArray(numbers.size)




        search(0,numbers,"")


        return max.toString()
    }
    fun search(count  : Int , numbers: IntArray , num : String ){

        if(count==numbers.size){
            if(max<num){
                max = num
            }
        }
        if(max.length>num.length){
            var gap = max.length - num.length
        }
        for(i in numbers.indices){
            if(!visited[i]){
                visited[i] =true

                search(count+1 , numbers , "${num}${numbers[i]}")
                visited[i] = false
            }
        }
    }
}
//35, 423, 19, 22, 66, 44, 111, 34, 33, 32, 9, 91, 8
fun main(){
    var solution = Solution()
    println(solution.solution(intArrayOf(35, 423, 19, 22, 66, 44, 111, 34, 33, 32, 9, 91, 8)))
}


