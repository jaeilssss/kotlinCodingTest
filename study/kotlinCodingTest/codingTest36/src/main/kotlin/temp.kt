

fun main(){

//
//    var t : Char = 'a'
//    var b : Byte = 97
//    print(b.toChar())

    var s = "11100211"
    var t = "1"
    var q : Int = 1000000000
    println(s.startsWith(t))

}

class temp(var i  :Int):Comparable<temp>{
    override fun compareTo(other: temp): Int {
        return this.i - other.i
    }

}