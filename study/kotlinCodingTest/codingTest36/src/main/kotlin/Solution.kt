import kotlin.math.max

class Solution {
    var map = HashMap<String,ArrayList<String>>()
    var answer = arrayOf<String>()
    var maxSize = 0
    var maxPath = ""
    var ansList = ArrayList<String>()
    fun solution(tickets: Array<Array<String>>): Array<String> {


        answer = Array(tickets.size+1){""}
        maxSize = tickets.size+1

        for(i in tickets.indices){

            var list = map.getOrDefault(tickets[i][0], ArrayList())
            list.add(tickets[i][1])
            map.put(tickets[i][0],list)
        }

        for(key  in map.keys){
            var list = map[key]

            if (list != null) {
                list.sort()
                map.put(key,list)
            }
        }

        answer[0] = "ICN"
        search("ICN",1,"ICN")

        ansList.sort()
        var arr = ansList[0].split(" ").toTypedArray()

        return arr
    }

    fun search(key : String , idx : Int  , path : String) : Boolean{


        if(idx==maxSize){
        ansList.add(path)
            return true
        }else{
            var list = map.getOrDefault(key,ArrayList())
            var num = list.size

            for(i in 0 until num){
                var str = list.get(i)

                list.removeAt(i)
                map.put(key, list)
              var check =   search(str, idx+1,"$path $str")
                if(check){
                    return true
                }
                list.add(i,str)
                map.put(key, list)
            }
        }

            return false
    }

}




fun main(){
    var Solution  = Solution()
    var arr = Solution.solution(arrayOf(arrayOf("ICN" ,"A"), arrayOf("ICN" ,"B"),  arrayOf("B","ICN")))
    for(i in arr.indices){
        println(arr[i])
    }
}

