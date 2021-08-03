class Solution {
    fun solution(s: String): Boolean {
        var answer = true

        if((s.length==4 || s.length==8).not()){
            return false
        }
        var array  : List<Char> = s.toList()


        for(char in array){
            var num = char.toInt()

            if(num !in 48..57){
                return false
            }
        }
        return answer
    }
}
