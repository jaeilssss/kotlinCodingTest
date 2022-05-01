class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        answer = IntArray(queries.size)
        var arr: Array<IntArray> = Array(rows) { IntArray(columns) }

        var num = 1
        for (i in 0 until rows) {
            for (j in 0 until columns) {
                arr[i][j] = num
                num++
            }

        }

        for (i in queries.indices) {
            var x1 = queries[i][0]
            var y1 = queries[i][1]
            var x2 = queries[i][2]
            var y2 = queries[i][3]

            var x = x1 - 1
            var y = y1
            var temp = arr[x1 - 1][ y1 - 1]
            var min = temp
            while (x != x1 - 1 || y != y1 - 1) {

                min = Math.min(min, arr[x][y])
                var temp2 = arr[x][y]
                arr[x][y] = temp
                temp = temp2

                if (y < y2 - 1 && x == x1 - 1) {
                    y++
                } else if (y == y2 - 1 && x != x2 - 1) {
                    x++
                } else if (x == x2 - 1 && y > y1 - 1) {
                    y--
                } else if (y == y1 - 1 && x > x1 - 1) {
                    x--
                }

            }
            arr[x1-1][y1-1] = temp

            min = Math.min(min,  arr[x1-1][y1-1])
            answer[i] = min

        }
        for(w in 0 until rows){
            for(j in 0 until columns){
                print(arr[w][j])
            }
            println()
        }

        return answer
    }

}
fun main() {
    var sol = Solution()

    var answer =
        sol.solution(6, 6, arrayOf(intArrayOf(2, 2, 5, 4,), intArrayOf(3, 3, 6, 6,), intArrayOf(5, 1, 6, 3)))

//    for(i in answer.indices){
//        println(answer[i])
//    }
}
