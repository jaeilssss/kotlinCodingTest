import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int i=0;
        Arrays.sort(d);

        while (true){
            if(budget==0 || i==d.length){
                break;
            }else{
                if(budget>=d[i]){
                    budget -= d[i++];
                    answer++;
                }else{
                    break;
                }
            }
        }
        return answer;
    }
}