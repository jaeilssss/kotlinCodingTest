import java.util.regex.Pattern

class Solution {
    var answer = HashSet<HashSet<String>>()
    var list = ArrayList<ArrayList<String>>()
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {



        banned_id.forEach {
        list.add(getMatched(user_id,it))
        }


        dfs(HashSet(),0)


        return answer.size
    }

    fun getMatched(user_id: Array<String>, bannedId : String ) : ArrayList<String>{

        var arrayList = ArrayList<String>()
        var ban = bannedId.replace('*','.')
        user_id.forEach {

            if(Pattern.matches(ban,it)){
                arrayList.add(it)
            }
        }
        return arrayList
    }

    fun dfs(set : HashSet<String> , depth : Int){

        if(depth==list.size){
            answer.add(HashSet(set))
            return
        }
        list.get(depth).forEach{
            if(!set.contains(it)){
                set.add(it)
                dfs(set,depth+1)
                set.remove(it)
            }
        }


    }
}


fun main(){
    var solution = Solution()
    println(solution.solution(
        arrayOf("frodo", "fradi", "crodo", "abc123", "frodoc"),
        arrayOf("*rodo", "*rodo", "******")
    ))

}