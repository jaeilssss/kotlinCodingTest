import kotlin.math.abs
val bre = System.`in`.bufferedReader()
fun main() = with(System.out.bufferedWriter()){

    var (n,m,b) = bre.readLine().split(" ").map { it.toInt() }
    var block : Array<IntArray> = Array(n){ IntArray(m) }
    var max = -1
    var min = 257
    var timeMin=Int.MAX_VALUE
    var height=0

    for(i in 0 until n){
        var temp = bre.readLine().split(" ").map { it.toInt() }

        for(j in temp.indices){
            block[i][j] = temp.get(j)
            min = Math.min(min,block[i][j])
            max = Math.max(max,block[i][j])
        }
    }

for(i in min until max+1){
    var inventory = b
    var time = 0

    for(j in 0 until n){

        for(a in 0 until  m){

            var diff = i-block[j][a]

            if(diff>0){
                time +=diff
                inventory -= diff

            }else if(diff<0){
                time += abs(diff)*2
                inventory += abs(diff)
            }
        }

    }
    if(inventory>=0){
        if(time<=timeMin ){

            timeMin = time
            height = i
        }
    }
}
println("${timeMin} ${height}")
}






