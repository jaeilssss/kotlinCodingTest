class Solution {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = 0
        var  currentMoney =money

        var currentPrice = 0.0
        for( i in 1..count){
            currentPrice += (price * i)
        }

        if(currentPrice>=money){
            return (currentPrice-money).toLong()
        }else{
            return 0
        }
    }
}

