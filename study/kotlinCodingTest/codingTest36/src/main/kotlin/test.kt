
import java.util.*

var arr = intArrayOf(1,5,10,50)
var visited : BooleanArray = booleanArrayOf()
var ans = 0
var sb = StringBuffer()
fun main() = with(System.out.bufferedWriter()) {
    var(N,M,T) = readLine()!!.split(" ").map {it.toInt() }

    var num = readLine()!!.split(" ").map{it.toInt()}

    var sb = StringBuffer()
    T--
    for(i in 0 until M){
        var k = readLine()!!.toInt()
        if(k<N){
            sb.append(num[k])
            sb.append("\n")
        }else if(k==N){
            sb.append(num[T])
            sb.append("\n")
        }else{
            sb.append(num[(k-T)%(N-T)+T])
            sb.append("\n")
        }
    }

    println(sb.toString())
}
fun plus(count : Int ,idx : Int, sum : Int , N : Int){

    if(count==N){
        if(!visited[sum]){
            visited[sum]  = true
            ans++
        }
        return
    }else{
        for(i in idx until arr.size){

            plus(count+1,i,sum+arr[i],N)
        }
    }


}



class Point(var x : Int , var y : Int) :Comparable<Point>{

    override fun compareTo(other:Point) : Int{
        var thisFirst = 0
        var thisSecond =0
        var otherFirst=0
        var otherSecond=0
        if(this.x>this.y){
            thisFirst = this.x
            thisSecond = this.y
        }else{
            thisFirst=this.y
            thisSecond=this.x
        }

        if(other.x>other.y){
            otherFirst = other.x
            otherSecond = other.y
        }else{
            otherFirst=other.y
            otherSecond=other.x
        }

        if(thisFirst==otherFirst){
            return otherSecond -thisSecond
        }
        return otherFirst-thisFirst
    }
}











