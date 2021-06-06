
import kotlin.collections.ArrayList
import kotlin.math.sign
import java.util.*
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0

        var bridgeQueue  = LinkedList<Int>()
        var waitQueue  = LinkedList<Int>()

        for(i in 0 until bridge_length) bridgeQueue.add(0)
        for(i in truck_weights.indices) waitQueue.add(truck_weights[i])

        while(bridgeQueue.isNotEmpty()){
            answer++
            bridgeQueue.poll()
            if(waitQueue.isNotEmpty()){
                if (bridgeQueue.sum() <= weight - waitQueue.peek()) {
                    bridgeQueue.add(waitQueue.poll())
                } else {
                    bridgeQueue.add(0)
                }
            }
        }
        return answer
    }
}
