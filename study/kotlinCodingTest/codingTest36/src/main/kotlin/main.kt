import kotlin.math.min

fun main(){
    var answer = 0
    var str = readLine()
    var count = readLine()?.toInt()
    var list = ArrayList<Int>()
    for(i in 0 until count!!){
        var num = readLine()?.toInt()
        if (num != null) {
            list.add(num)
        }
    }

    var chars = str!!.split(" ")

    var bucketWidth = chars[1].toInt()
    var head = 1
    var tail = bucketWidth


    for(i in list.indices){
        var apple = list.get(i)
        if(tail<apple){

            var temp = apple-tail

            answer += temp
            head +=temp
            tail+=temp

        }else if(head>apple){

            var temp=head -apple

            answer += temp
            head -=temp
            tail-=temp
        }
    }

println(answer)
}