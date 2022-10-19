
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*


val dir = arrayOf(arrayOf(-1,0),arrayOf(0,1),arrayOf(1,0),arrayOf(0,-1))
fun main() = with(System.out.bufferedWriter()){


    val br = System.`in`.bufferedReader()

    var num = br.readLine().toInt()

    var arr = Array<IntArray>(num){ IntArray(num) }


    var point  = br.readLine().toInt()

    var x = (num/2)
    var y = (num/2)
    var curIndex =0
    var movMax=1
    var cntMov =0
    var n = 1
    var answer = Pair<Int,Int>(0,0);
    arr[x][y] = n++
    while (true){


        x += dir[curIndex%4][0]
        y += dir[curIndex%4][1]
        if(x !in 0 until num || y !in 0 until num) break

        arr[x][y] = n++

        if(arr[x][y]==point){
            answer = Pair(x,y)
        }
        cntMov++
        if(movMax==cntMov){
            curIndex++
            cntMov = 0

            if(curIndex%2==0){
                movMax++
            }
        }
    }

    for(i in 0 until num){

        for(j in 0 until num){

            write("${arr[i][j]} ")

        }
        write("\n")
    }

    write("${answer.first+1} ${answer.second+1}")
    close()
}















