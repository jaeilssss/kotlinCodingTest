import java.util.*


fun main() = with(System.out.bufferedWriter()){

    var temp = br.readLine().toCharArray()


    var stack = Stack<Char>()
    var sum=0
    var answer=0
    for(i in temp.indices){


    if(stack.isEmpty()){
        stack.push(temp[i])
    }else{
        if(temp[i]==')' && stack.peek()=='('){
            stack.pop()
            if(stack.isNotEmpty()){
                sum+=2
            }else{
                if(sum!=0){
                    sum *=2
                }else{
                    sum +=2
                }
                answer +=sum
            }
        }else if(temp[i]==']' && stack.peek()=='['){
            stack.pop()
            if(stack.isNotEmpty()){
                sum+=3
            }else{
                if(sum!=0){
                    sum *=3
                }else{
                    sum +=3
                }
                answer +=sum
            }
        }else{
            stack.push(temp[i])
        }
    }
    }

    if(stack.isNotEmpty()){
        println(0)
    }else{
        println(answer)
    }

}