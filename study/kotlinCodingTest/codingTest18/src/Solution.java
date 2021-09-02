import java.util.Arrays;

class Solution {
    
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i =  0; i <prices.length ; i++){
            int count = 0;

            for(int  j =i+1 ; j < prices.length;j++){

                if(prices[i]<=prices[j]){
                    count++;
                }else{
                    count++;
                    break;
                }
            }
            answer[i]=count;
        }
        return answer;
    }


    public static void main(String [] args){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 2, 3, 1})));
    }
}