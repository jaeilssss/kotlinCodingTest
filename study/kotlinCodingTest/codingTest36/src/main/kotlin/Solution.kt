class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()

        answer  = IntArray(2)
        var count = 0
        var zeroCount =0
        var arr = s.toCharArray()
        while (arr.size!=1){
            count++
             var temp = ""
            for(i in arr.indices){
                if(arr[i]!='0'){
                    temp +="1"
                }else{
                    zeroCount++
                }
            }

            arr =Integer.toBinaryString((temp.length)).toCharArray()


        }

        answer[0]=count
        answer[1]=zeroCount


        println(answer[0])
        println(answer[1])
        return answer
    }
}

fun main(){
    Solution().solution("1111111")
}