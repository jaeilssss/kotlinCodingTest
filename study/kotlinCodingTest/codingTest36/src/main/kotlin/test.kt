import java.util.*
import kotlin.collections.ArrayList

var arr : Array<ArrayList<Node>> = arrayOf()
var dist : IntArray = intArrayOf()
var visit : BooleanArray = booleanArrayOf()
fun main(){
    var scanner = Scanner(System.`in`)


    var T = scanner.nextInt()

    for(i in 0 until T){

        var N = scanner.nextInt()
        var M = scanner.nextInt()
        var total = IntArray(N+1){0}
        var person = ArrayList<Int>()
        arr = Array(N+1){ ArrayList() }


        for(j in 0 until M){

            var a = scanner.nextInt()
            var b = scanner.nextInt()
            var c = scanner.nextInt()

            arr[a].add(Node(b,c))
            arr[b].add(Node(a,c))
        }

        var K = scanner.nextInt()

        for(j in 0 until K){
            person.add(scanner.nextInt())
        }

        for(j in person.indices){
            dist  = IntArray(N+1)
            visit = BooleanArray(N+1)
            search(person[j])

            for(k in 1 .. N){
                total[k] += dist[k]
            }

        }

        var min = Int.MAX_VALUE
        var idx =-1
        for(j in 1 until total.size){
            if(min>total[j]){
                min = total[j]
                idx = j
            }
        }
        println(idx)
    }

}

fun search(idx : Int){
    var queue = LinkedList<Node>()

    queue.add(Node(idx,100))

    visit[idx]=true
    dist[idx]=0

    while (!queue.isEmpty()){
        var node= queue.poll()

        for(i in arr[node.idx].indices){

            var temp = arr[node.idx][i]

            if(!visit[temp.idx]){
                queue.add(temp)
                dist[temp.idx] = temp.weight+dist[node.idx]
                visit[temp.idx] = true
            }else if(dist[temp.idx]>temp.weight+dist[node.idx]){

                dist[temp.idx] = temp.weight+dist[node.idx]
                queue.add(temp)
            }

        }
    }
}

class Node(var idx : Int , var weight : Int)








