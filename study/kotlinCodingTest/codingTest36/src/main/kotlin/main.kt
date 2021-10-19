
fun main(){

    var str = readLine()!!.split(" ").map { it.toInt() }

    var array :Array<IntArray> = Array(str[0]){ IntArray(str[1]) }
    for(i in 0 until str[0]){
        var temp = readLine()!!.toCharArray()
        var count = -1
        for(j in 0 until str[1]){
            if(temp[j].equals('.')){
                array[i][j] = count
                if(count!=-1){
                    count++
                }
            }else if(temp[j].equals('c')){
                count = 1
                array[i][j]=0
            }
        }
    }

    for(i in 0 until str[0]){
        for(j in 0 until str[1]){
            print("${array[i][j]} ")
        }
        println()
    }

}






