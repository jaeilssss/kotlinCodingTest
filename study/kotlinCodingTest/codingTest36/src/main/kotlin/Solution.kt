class Solution {
    var answer = 0
    var size =0
    var wantedNumber  =0
    lateinit var numbers : IntArray
    fun solution(numbers: IntArray, target: Int): Int {
        wantedNumber = target
        size = numbers.size
                this.numbers = numbers
        search(numbers[0],0,1)
        search(numbers[0]*-1,0,1)
        return answer
    }
    fun search(num : Int,sum : Int ,index :Int){
        var temp = sum+num

        if(index==size){

            if(temp==wantedNumber){

               answer++
            }
            return
        }

        search(numbers[index],temp,index+1)
        search(numbers[index]*-1,temp,index+1)

    }
}
fun main(){
    println(Solution().solution(intArrayOf(1,1,1,1,1),3))
}





