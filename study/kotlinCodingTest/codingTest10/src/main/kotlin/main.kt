fun main(args : Array<String>) {

var str = "a"
    var new_id = "-#abaa"
    var answer: String = ""
    answer = new_id
    var temp = answer
    println(str[0].toInt())
    for(i in new_id.indices){
        if(temp[i].toInt()==77){
            println("tlqkf")
        }
        if((temp[i].toInt() in 97..122).not() &&
            (temp[i].toInt()==77) &&
            (temp[i].toInt()==78) &&
            (temp[i].toInt()==127)
        ){
            if(temp[i].equals(".")){
                println(temp[i])
            }
            println("??")
            answer = answer.replace("${temp[i]}","")
        }
    }
    println(answer)
}//메인 종료