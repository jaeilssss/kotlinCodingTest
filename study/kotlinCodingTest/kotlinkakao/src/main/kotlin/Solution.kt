 class Solution {
    fun conversion(number: Int, N: Int): String {
        val sb = StringBuilder()
        var current = number
        while (current > 0) {
            if (current % N < 10) {
                sb.append(current % N)
            } else {
                sb.append((current % N - 10 + 'A'.toInt()).toChar())
            }
            current /= N
        }
        return sb.reverse().toString()
    }

    fun solution(n: Int, k: Int): Int {
        var answer = 0
        var str = ""
        str = if (k != 10) {
            conversion(n, k)
        } else {
            n.toString()
        }
        var result = true
        val list = str.split("0").toTypedArray()
        for (i in list.indices) {
            if (list[i] != "") {
                val num = list[i].toInt()
                if (num != 1) {
                    for (j in 2 until num) {
                        if (num % j == 0) {
                            result = false
                            break
                        }
                    }
                    if (result) {
                        answer++
                    } else {
                        result = true
                    }
                }
            }
        }
        return answer
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(
                Solution().solution(1, 3)
            )
        }
    }
}