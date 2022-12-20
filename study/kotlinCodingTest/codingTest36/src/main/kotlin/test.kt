import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs


fun main(){
     fun stoi(input: String): Int {
        return input.toInt()
    }
    var scanner = Scanner(System.`in`)



    var pq = PriorityQueue<Box>(compareByDescending { it.priority })

    var queue = LinkedList<Box>()

    var stack = Stack<Box>()

    var answer : Long = 0

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
  var  N = stoi(st.nextToken())
  var  M = stoi(st.nextToken())

    for(i in 0 until N){

        st = StringTokenizer(br.readLine())
        val priority = stoi(st.nextToken())
        val weight = stoi(st.nextToken())

        pq.add(Box(weight,priority,M))
        queue.add(Box(weight,priority,M))
    }

    while (!queue.isEmpty()){

        if(pq.peek().priority == queue.peek().priority){

            if(stack.isEmpty()){
                var n = queue.poll()
                answer += n.weight
                stack.push(n)
            }else{
                var temp = ArrayList<Box>()
                for(i in 0 until stack.size){
                    if(stack.peek().priority==queue.peek().priority){
                        if(stack.peek().weight<queue.peek().weight){
                            temp.add(stack.pop())
                        }else{
                            break
                        }
                    }else{
                        break
                    }

                }

                var n = queue.poll()
                answer+= n.weight
                stack.push(n)
                for(i in temp.indices){

                    answer+=(temp[i].weight*2)
                    stack.push(temp[i])
                }
            }
            pq.poll()


        }else {
            var n = queue.poll()
            answer+=n.weight
            queue.add(n)
        }
    }

    println(answer)

}

class Box(var weight : Int , var priority : Int , var  M : Int) {


}