class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""
        answer = new_id

        // 1step
        answer = new_id.toLowerCase()

        //2step
        var temp = answer


        for(i in new_id.indices){
            if(!(temp[i].toInt() in 97..122) &&
                temp[i].equals("-").not() &&
                temp[i].equals("_").not() &&
                temp[i].equals(".").not()
                    ){

                answer = answer.replace("${temp[i]}","")
            }
        }

        //3step
        temp = answer
        answer = answer.replace("..",".")

        //4step
        if(answer[0].equals(".")){
            answer.removeRange(0,1)
        }

        if(answer.length==0){
            answer = "a"
        }

        if(answer.length>=16){
            answer = answer.removeRange(16,answer.length)
            if(answer[15].equals(".")){
                answer.removeRange(15,16)
            }

        }
        if(answer.length<=2){
            while(true){
                if(answer.length==3){
                    break
                }else{
                    answer += answer[answer.length - 1]
                }
            }
        }

        return answer
    }
}