fun main(args : Array<String>) {

var str = "a"
    var new_id = "abcdefghijklmn.p"
    var answer: String = ""
    answer = new_id
    var temp = answer
    if(answer[0].equals('.')){

        answer = answer.removeRange(0,1)
    }
    println(answer[answer.length-1])
    if(answer[answer.length-1] == '.'){
        answer = answer.removeRange(answer.length-1,answer.length)
    }
    answer = Solution().solution(new_id)
    if(answer[14].equals('.')){
        answer = answer.removeRange(14,15)
    }
    println(answer)
}//메인 종료