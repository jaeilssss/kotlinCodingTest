import java.util.*
import kotlin.collections.ArrayList

fun main(){

    var scanner = Scanner(System.`in`)

    var answer = 0
    var N = scanner.nextInt()

    var pq = PriorityQueue<Int>(compareByDescending { it })
    var list = ArrayList<Int>()

    for(i in 0 until N){
        pq.add(scanner.nextInt())
    }


    while (pq.size!=0){
        answer++

        if(answer>1440){
            println(-1)
            return
        }
        if(pq.size>=2){

            var  n  = pq.poll()
            var s = pq.poll()

            if(n-1>0){
                pq.add(n-1)

            }
            if(s-1>0){
                pq.add(s-1)
            }

        }else if(pq.size==1){
            var  n = pq.poll()
            if(n-1>0){
                pq.add(n-1)
            }
        }
    }

    println(answer)

}
