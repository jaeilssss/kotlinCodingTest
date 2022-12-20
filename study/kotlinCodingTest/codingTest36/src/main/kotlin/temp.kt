import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

object Main {
    var N = 0
    var M = 0
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val br = BufferedReader(InputStreamReader(System.`in`))
        var st = StringTokenizer(br.readLine())
        N = stoi(st.nextToken())
        M = stoi(st.nextToken())
        val rails: Deque<Container> = ArrayDeque()
        val count = IntArray(M + 1)
        for (i in 0 until N) {
            st = StringTokenizer(br.readLine())
            val priority = stoi(st.nextToken())
            val weight = stoi(st.nextToken())
            count[priority]++
            rails.addLast(Container(priority, weight))
        }
        var targetPriority = M
        var answer = 0
        val stack = Stack<Container>() // 적재하는 저장소
        while (!rails.isEmpty()) {
            val container = rails.pollFirst()
            val priority = container.priority
            val weight = container.weight
            if (isLowestPriority(count, priority)) {    // 낮은 우선순위의 컨테이너가 남아있을 경우
                rails.addLast(Container(priority, weight))
                answer += weight
                continue
            }
            answer += weight

            // 무거운 무게의 컨테이너가 가장 아래로 이동
            val tempStack = Stack<Container>()
            while (!stack.isEmpty() && stack.peek().weight < weight && stack.peek().priority == targetPriority) {
                val tempContainer = stack.pop()
                answer += tempContainer.weight
                tempStack.add(tempContainer)
            }
            stack.add(Container(priority, weight))
            while (!tempStack.isEmpty()) {
                val tempContainer = tempStack.pop()
                answer += tempContainer.weight
                stack.add(tempContainer)
            }
            count[targetPriority]--
            if (count[targetPriority] == 0) {
                targetPriority--
            }
        }
        println(answer)
    }

    private fun isLowestPriority(count: IntArray, priority: Int): Boolean {
        for (i in M downTo priority + 1) {
            if (count[i] > 0) // 더 낮은 우선순위가 존재할 경우
                return true
        }
        return false
    }

    private fun stoi(input: String): Int {
        return input.toInt()
    }

    internal class Container(var priority: Int, var weight: Int)
}