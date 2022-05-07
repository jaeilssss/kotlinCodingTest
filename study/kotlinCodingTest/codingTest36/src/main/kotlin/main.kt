
import java.util.*

fun main()  {
    var scanner = Scanner(System.`in`)
    var n = scanner.nextInt()
    var k = scanner.nextInt()

    var answer =0
        while (true){

            var temp = n +answer
            var count = 0
            while(temp>0){
                if(temp %2 !=0){
                    count++
                }
                temp /=2
            }

            if(count<=k){
                println(answer)
                break
            }
            answer++
        }

}
