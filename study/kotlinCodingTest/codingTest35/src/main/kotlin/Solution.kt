class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0

        var str = change(n)
        println(str)
        answer = getValue(str)


        return answer
    }
    fun getValue(str : String) : Int{
        var sum = 0
        var chars = str.toCharArray()
        var temp = 0

        sum = Integer.parseInt(chars[chars.size-1].toString())
        for(i in 0 until chars.size-1){
            temp = Integer.parseInt(chars[i].toString())
            var num = 0
            for(j in i until str.length-1){
                if(num==0){
                    num=3
                }else{
                    num *= 3
                }
            }
            sum +=temp*num
        }

        return sum
    }
    fun change(n : Int) : String{
        var str = ""
        var num = n
        while(true){
            if(num>=3){
                str += (num % 3).toString()
                num /= 3
            }else{
                str += (num % 3).toString()
                break
            }
        }

        return str
    }
}
fun main(){
    println(Solution().solution(3))

}