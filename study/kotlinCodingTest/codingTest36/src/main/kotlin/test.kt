import java.util.*
import kotlin.collections.ArrayList

fun main(){

    var scanner = Scanner(System.`in`)


    var  C =scanner.nextInt()

    for(i in 0 until C){

        var N = scanner.nextInt()
        var M = scanner.nextInt()
        var search = 0
        var pq = PriorityQueue<Int>(compareByDescending { it })
        var queue = LinkedList<Int>()
        for(j in 0 until N){

            var n = scanner.nextInt()
            pq.add(n)
            queue.add(n)
            if(j==M){
                search = n
            }
        }


        var count = 1
        var idx = 0
        while (true){


            if(queue.peek()!=pq.peek()){
                if(idx==M){
                    M += queue.size
                }
                var n = queue.poll()
                queue.add(n)

            }else{
                if(idx==M){
                    println(count)
                    break
                }else{
                    pq.poll()
                    queue.poll()
                    count++
                }
            }
            idx++
        }

    }

}
