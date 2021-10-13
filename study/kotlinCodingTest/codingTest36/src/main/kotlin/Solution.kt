class Solution {
    fun solution(record: Array<String>): Array<Any> {

        var member = HashMap<String,String>()
        var count = 0
        for(i in record.indices){
            var str = record[i].split(" ")
            if(str.size==3){
                member.put(str[1],str[2])
            }
        }
        var answer = ArrayList<String>()
        for(i in record.indices){
            var str = record[i].split(" ")
            if(str[0].equals("Enter")){

                answer.add("${member.get(str[1])}님이 들어왔습니다.")

            }else if(str[0].equals("Leave")){

                answer.add("${member.get(str[1])}님이 나갔습니다.")

            }

        }


        return answer.toArray()
    }
}

fun main(){
    var data = Solution().solution(arrayOf("Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"))

    for(i in data.indices){
        print(data[i])
    }
}


