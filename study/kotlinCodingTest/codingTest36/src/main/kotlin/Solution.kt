class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        for(i in strings.indices){

            for(j in i+1 until strings.size){
                if(strings[i][n] > strings[j][n]){

                    var temp = strings[i]
                    strings[i]=strings[j]
                    strings[j]=temp
                }else if(strings[i][n]==strings[j][n]){
                    if(strings[i]>strings[j]){
                        var temp = strings[i]
                        strings[i]=strings[j]
                        strings[j]=temp
                    }
                }
            }
        }
        return strings
    }
}
fun main(){
    var list = Solution().solution(
        arrayOf("sun", "bed", "car"),
        1
    )
    for(i in list.indices){
        println(list[i])
    }
}