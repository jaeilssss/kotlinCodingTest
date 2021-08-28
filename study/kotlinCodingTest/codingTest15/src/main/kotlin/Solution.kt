import javax.print.attribute.IntegerSyntax

class Solution {
    fun solution(table: Array<String>, languages: Array<String>, preference: IntArray): String {
        var answer: String = ""
        var list = ArrayList<String>()
        list.add("SI")
        list.add("CONTENTS")
        list.add("HARDWARE")
        list.add("PORTAL")
        list.add("GAME")
        var sum = 0
        var max = 0
        var maxIndex=0
        for(i in table.indices){
            var str = table[i].split(" ")
            for(j in languages.indices){
              var num= str.indexOf(languages[j])
                if(num!=-1){
                    num = 6-num
                    sum += (num * preference[j])
                }
            }

            if(max<sum){
                max = sum
                maxIndex = i
            }else if(max==sum){
                if(list[maxIndex] >list[i]){
                    maxIndex = i
                }
            }
            sum=0
        }

        if(maxIndex==0){
            answer="SI"
        }else if(maxIndex==1){
            answer="CONTENTS"
        }else if(maxIndex==2){
            answer = "HARDWARE"
        }else if(maxIndex==3){
            answer="PORTAL"
        }else if(maxIndex==4){
            answer="GAME"
        }
        return answer
    }
}

fun main(){
    if("a">"b"){
        println("a")
    }else{
        println("b")
    }
}