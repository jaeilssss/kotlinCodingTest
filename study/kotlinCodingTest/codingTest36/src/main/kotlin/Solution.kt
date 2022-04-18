class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer: IntArray = intArrayOf()

        answer = IntArray(id_list.size)
        var map = HashMap<String,Int>()
        var indexMap = HashMap<String,Int>()
        var checkList : Array<IntArray> = Array(id_list.size){IntArray(id_list.size)}
        var reportList = ArrayList<String>()
        for(i in id_list.indices){
            map.put(id_list[i],0)
            indexMap.put(id_list[i],i)
        }

        for(i in report.indices){
            var array = report[i].split(" ")
            var u1 = indexMap.get(array[0])
            var u2 = indexMap.get(array[1])
            if(checkList[u1!!][u2!!]==0){
                map.put(array[1],map.get(array[1])!!+1)
                checkList[u1][u2]=1
                reportList.add(report[i])
            }
        }

        for(i in reportList.indices){
            var array = reportList[i].split(" ")
            var userIndex= indexMap.get(array[0])
            if(map.get(array[1])!!>=k){
                answer[userIndex!!]++
            }
        }

        return answer
    }
}

fun main(){

}