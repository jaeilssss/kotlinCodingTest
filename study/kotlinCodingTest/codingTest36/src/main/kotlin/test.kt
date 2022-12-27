import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
fun main(){


    var scanner = Scanner(System.`in`)

    var N = scanner.nextInt()

    var M = scanner.nextInt()


    var queue = LinkedList<Box>()

    var answer = 0
    var pq = PriorityQueue<Box>(compareByDescending { it.priority })
    var stack = Stack<Box>()
    for(i in 0 until N){
        var p = scanner.nextInt()
        var w = scanner.nextInt()

        queue.add(Box(w,p,M))
        pq.add(Box(w,p,M))

    }

    while (queue.isNotEmpty()){

        if(queue.peek().priority == pq.peek().priority){

            var temp = Stack<Box>()
            for(i in stack.indices){

                if(stack.peek().priority == queue.peek().priority){
                    if(stack.peek().weight<queue.peek().weight){
                        temp.push(stack.pop())
                    }else{
                        break
                    }
                }else{
                    break
                }

            }
            var n = queue.poll()
            answer +=n.weight
            stack.push(n)
            for(i in temp.indices){

                answer += (temp.peek().weight*2)
                stack.push(temp.pop())

            }
            pq.poll()

        }else{

            answer += queue.peek().weight
            queue.add(queue.poll())
        }

    }

    println(answer)

}

class Box(var weight : Int , var priority : Int , var  M : Int)
