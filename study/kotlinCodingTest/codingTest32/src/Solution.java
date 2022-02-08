import java.util.*;

class Solution {


    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int  i = 0 ; i<scoville.length; i++){
            heap.offer(scoville[i]);
        }


        while (heap.peek() <=K){
            if(heap.size()==1){
                return -1;
            }else{
                int num1 = heap.poll();
                int num2 = heap.poll();

                int result = num1 + (num2*2);

                heap.offer(result);

                answer++;
            }
        }


        return answer;
    }

    public static void main(String [] args){
        Solution solution = new Solution();

        System.out.println(solution.solution(new int[]{1, 2, 3, 9, 10, 12},7));
    }
}