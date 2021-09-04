class Solution {
    fun solution(left: Int, right: Int): Int {
        var answer: Int = 0
        for(num in left..right){
            var list = ArrayList<Int>()
            for(i in 1..num){
                if(num%i==0){
                    list.add(i)
                }
            }
            if(list.size%2==0){
                answer += num
            }else{
                answer -=num
            }
        }
        return answer
    }
}