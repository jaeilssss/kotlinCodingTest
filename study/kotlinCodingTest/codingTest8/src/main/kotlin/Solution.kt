class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()

        var map = HashMap<Int , Int>()

        for(i in numbers.indices){

            for(j in i until numbers.size){
                if(i!=j){
                    var sum = numbers[i]+numbers[j]
                    map.put(sum,sum)
                }
            }
        }
        var index = 0
        answer = IntArray(map.size)
        for(i in map.keys){

            answer.set(index++,i)
        }

        answer.sort()

        return answer
    }
}