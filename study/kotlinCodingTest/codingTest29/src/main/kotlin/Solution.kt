import com.sun.org.apache.xpath.internal.operations.Bool

class Solution {
    var list = ArrayList<Char>()
    var tempList = ArrayList<Int>()
    var map = HashMap<Int,Boolean>()
    fun solution(numbers: String): Int {
        var answer = 0
        var test= true
         list = numbers.toList() as ArrayList<Char>
        for(i in list.indices){
            search(i)
        }

        for(i in list.indices){

            for(j in 2 until tempList[i] ){
                if(tempList[i]/j==0){
                    test = false
                    break
                }
            }
            if(test){
                answer++
            }
        }

        return answer
    }

    fun search(start: Int){
        var temp  : String = list[start].toString()
        var temp2 : String = list[start].toString()
        var num  = Integer.parseInt(temp)
        var num2 =0
        tempList.add(num)
        for(i in list.indices){
            if(i!=start){
                temp = "${temp}${list[i]}"
                temp2 = "${list[i]}${temp2}"
                 num  = Integer.parseInt(temp)
                num2 = Integer.parseInt(temp2)
                if(!tempList.contains(num)){
                    tempList.add(num)
                }
                if(!tempList.contains(num2)){
                    tempList.add(num2)
                }

            }
        }
    }
}

fun main(){
println(Solution().solution("17"))
}