class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0
        var str = ""
        for(i in 0..s.length-1){
            str += s[i]
            if(s[i].toInt() in 48..57){
                if(answer==0){
                    answer += Integer.parseInt(str)
                }else{
                    answer  = answer*10 + Integer.parseInt(str)
                }
                str=""
            } else if(str.equals("zero")){
                if(answer==0){
                    answer = answer+0
                }else{
                    answer = answer*10+0
                }
                str = ""
            }else if(str.equals("one")){
                if(answer==0){
                    answer = answer+1
                }else{
                    answer=answer*10+1
                }
                str=""
            }else if(str.equals("two")){
                if(answer==0){
                    answer = answer+2
                }else{
                    answer = answer*10+2
                }
                str = ""
            }else if(str.equals("three")){
                if(answer==0){
                    answer= answer+3
                }else{
                    answer = answer*10+3
                }
                str = ""
            }else if(str.equals("four")){
                if(answer==0){
                    answer =answer+4
                }else{
                    answer = answer*10+4
                }
                str = ""
            }else if(str.equals("five")){
                if(answer==0){
                    answer = answer+5
                }else{
                    answer = answer*10+5
                }
                str = ""
            }else if(str.equals("six")){
                if(answer==0){
                    answer = answer+6
                }else {
                    answer = answer*10+6
                }
                str = ""
            }else if(str.equals("seven")){
                if(answer==0){
                    answer = answer+7
                }else {
                    answer = answer*10+7
                }
                str = ""
            }else if(str.equals("eight")){
                if(answer==0){
                    answer= answer+8
                }else {
                    answer = answer*10+8
                }
                str = ""
            }else if(str.equals("nine")){
                if(answer==0){
                    answer = answer+9
                }else{
                    answer= answer*10+9
                }
                str = ""
            }
        }
        return answer
    }

}