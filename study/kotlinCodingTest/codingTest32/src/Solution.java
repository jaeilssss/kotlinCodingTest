
import java.util.Arrays;

class Solution {

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= citations.length - i) {
                answer = citations.length - i;
                break;
            }
        }

        return answer;
    }

public static void main(String [] args){
        System.out.println(new Solution().solution(new int[]{25,8,5,3,3}));
}

}