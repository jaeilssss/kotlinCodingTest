import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

fun main(){

    var scanner = Scanner(System.`in`)

    var arr = IntArray(375){0}

    var N  = scanner.nextInt()

    var list = ArrayList<Point>()

    var start = -1
    var height = 0
    var answer = 0
    for(i in 0 until N){

        list.add(Point(scanner.nextInt() , scanner.nextInt()))
    }

    list.sort()

    for(i in list.indices){

        var point = list.get(i)

        for(j in point.start ..point.end){

            arr[j] = arr[j]+1
        }
    }

    for(i in 1 .. 367){

        if(arr[i]!=0 && start == -1){
            start = i
            height = arr[i]
        }else if(arr[i]==0 && start!=-1){

            answer += (i - start)*height

            start = -1

            height = 0
        }

        if(height<arr[i]){
            height = arr[i]
        }
    }

    println(answer)

}

class Point(var start : Int , var end : Int): Comparable<Point>{

    override fun compareTo(other: Point) : Int{

        return (other.end- other.start) - (this.end-  this.start)
    }
}
