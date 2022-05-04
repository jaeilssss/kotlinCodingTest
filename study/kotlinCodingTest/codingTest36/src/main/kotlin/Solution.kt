class Solution {

    fun solution(n: Int): IntArray {


        var answer = ArrayList<Int>()
        var arr  : Array<IntArray> = Array(n){IntArray(n)}

        var dir = arrayOf(arrayOf(1,0), arrayOf(0,1), arrayOf(-1,-1))
        var dirIdx = 0
        var x = 0
        var y = 0
        var num = 1
        var moveMax = n
        var count = 0
        while (moveMax!=0){
            arr[x][y]= num++

            count++
            if(count==moveMax){
                dirIdx++
                count=0
                moveMax--
            }
            x += dir[dirIdx%3][0]
            y += dir[dirIdx%3][1]
        }


for(i in 0 until n){
    for(j in 0 until n){
        if(arr[i][j]!=0){
            println(arr[i][j])
            answer.add(arr[i][j])
        }
    }
}
        return answer.toIntArray()
    }

}
fun main(){
Solution().solution(4)
}