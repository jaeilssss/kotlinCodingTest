fun main(){
    var s = "123"
    var answer = 0
    var str =""
    for(i in 0.. s.length-1){
        str += s[i]
        if(s[i].toInt() in 48..57){
            if(answer==0){
                answer += Integer.parseInt(str)
            }else{
                answer  = answer*10 + Integer.parseInt(str)
            }
            str=""
        }
    }

    println(answer)


}