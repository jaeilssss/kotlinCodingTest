class Solution {
    private var map = HashMap<String,MutableList<Int>>()
    fun solution(info: Array<String>, query: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()

        answer = IntArray(query.size)

        for(i in info.indices){

            var array = info[i].split(" ").toTypedArray()
            setting(0 ,"", array)
        }

        map.values.forEach{ it.sort() }

        for(i in query.indices){
            var array = query[i].split(" and ")
            var score = array[3].split(" ") // ex pizza 100 인 경우 and 로 구분되어 있지 않기 때문에 한번 더 split 을 해줘야함
            var key = "${array[0]}${array[1]}${array[2]}${score[0]}"
            var list =map.getOrDefault(key, mutableListOf())

            if(list.size==0){
                answer[i]=0
            }else{
                answer[i] = bs(list,score[1].toInt())
            }
        }
        return answer
    }
    fun setting(depth : Int , key : String , array  : Array<String>){

        if(depth==4){
            var list = map.getOrDefault(key , ArrayList())

            list.add(array[4].toInt())
            map[key] = list
            return
        }else{

           setting(depth+1 , "${key}${array[depth]}",array)
            setting(depth+1 ,"${key}-",array)


        }
    }


    fun bs(list: MutableList<Int>, target: Int): Int {
        var start = 0
        var end = list.size - 1

        while (start <= end) {
            val mid = (start + end) / 2
            if (list[mid] >= target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }

        return list.size - start
    }
}



fun main(){
var solution = Solution()

    var answer = solution.solution(arrayOf("java backend junior pizza 150","python frontend senior chicken 210",
        "python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"),
    arrayOf("java and backend and junior and pizza 100","python and frontend and senior and chicken 200",
        "cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"))
    for(i in answer.indices){
        println(answer[i])
    }
}