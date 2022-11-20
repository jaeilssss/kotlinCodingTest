
import java.util.*
import kotlin.collections.ArrayList

fun main() = with(System.out.bufferedWriter()) {



    var (N,M) = readLine()?.split(" ")!!.map { it.toInt() }


    if(N==1){
        println(1)
    }else if(N==2){
        println(kotlin.math.min(4,(M+1)/2))
    }else if(M<7){
        println(kotlin.math.min(4,M))
    }else{
        println(M-2)
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











