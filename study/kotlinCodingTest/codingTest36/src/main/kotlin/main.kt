
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

var emptyList = ArrayList<Place>()
var virusList = ArrayList<Place>()

var tempBlockList  : BooleanArray = booleanArrayOf()
var max = Integer.MIN_VALUE
var dx = intArrayOf(-1,0,1,0)
var dy = intArrayOf(0,-1,0,1)
var num : List<Int> = listOf()
fun main() {
    val bufferedReader = BufferedReader(InputStreamReader(java.lang.System.`in`))

     num = bufferedReader.readLine().split(" ").map { it.toInt() }
    var array :Array<IntArray> = arrayOf()
    array = Array(num[0]){IntArray(num[1])}



    for(i in  0 until num[0]){
        var temp = bufferedReader.readLine().split(" ").map { it.toInt() }
        
        for(j in temp.indices){
            array[i][j] = temp[j]
            if(temp[j]==0){
                emptyList.add(Place(i,j))

            }else if(temp[j]==2){
                virusList.add(Place(i,j))
            }
        }
    }

    tempBlockList =BooleanArray(emptyList.size){false}


    setBlock(0,array)

    println(max)
}

fun search(array : Array<IntArray>){
    var tempArray = Array<IntArray>(num[0]){IntArray(num[1])}
    var count = 0

    for(i in 0 until num[0]){
        for(j in 0 until num[1]){
            tempArray[i][j] = array[i][j]
        }
    }

    for(v in virusList.indices){
        var queue = LinkedList<Place>()
        var tmp = virusList[v]

        queue.add(tmp)

        while (queue.isNotEmpty()){
           var temp = queue.poll()

            for(d in 0 until 4){
                var tempX = temp.x+dx[d]
                var tempY = temp.y+dy[d]

                if(tempX>=0 && tempY>=0 && tempX<num[0] && tempY <num[1]){
                    if(tempArray[tempX][tempY]==0){
                        tempArray[tempX][tempY] = 2
                        queue.add(Place(tempX,tempY))
                    }
                }
            }
        }
    }

    for(a in 0 until num[0]){
        for(b in 0 until num[1]){
            if(tempArray[a][b]==0){
                count++
            }
        }
    }

    max = Integer.max(count,max)
}

fun setBlock(cnt : Int, array : Array<IntArray>){

    if(cnt==3){
        search(array)
    }else{
        for(i in emptyList.indices){

            if(!tempBlockList[i]){
                var x = emptyList[i].x
                var y = emptyList[i].y

                array[x][y] = 1
                tempBlockList[i]=true
                setBlock(cnt+1,array)
                array[x][y] = 0
                tempBlockList[i]=false
            }

        }
    }


}
class Place(var x : Int , var y : Int){
    
}

