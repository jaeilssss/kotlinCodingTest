class Solution {
    fun solution(new_id: String): String {
        var answer: String = new_id
        // 1step
        answer = new_id.toLowerCase()
        //2step
        var temp = answer
        for(i in new_id.indices){
            if(!(temp[i].toInt() in 97..122) &&
                !(temp[i].toInt() in 48..57) &&
                temp[i].equals('-').not() &&
                temp[i].equals('_').not() &&
                temp[i].equals('.').not()
            ){
                answer = answer.replace("${temp[i]}","")
            }
        }
        //3step
        answer = answer.replace("..",".")
        while(true){
            if(answer.contains("..")){
                answer = answer.replace("..",".")
            }else{
                break
            }
        }
        //4step
        if(answer[0].equals('.')){
            answer = answer.removeRange(0,1)
        }
        if(answer.length>0){
            if(answer[answer.length-1] == '.'){
                answer = answer.removeRange(answer.length-1,answer.length)
            }
        }

        //5step
        if(answer.length==0){
            answer = "a"
        }
        //6step
        if(answer.length>=16){
            answer = answer.removeRange(15,answer.length)
            if(answer[14].equals('.')){
                answer = answer.removeRange(14,15)
            }

        }
        //7step
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