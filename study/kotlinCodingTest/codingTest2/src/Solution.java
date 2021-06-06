public class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int max;
        int index=-1;
        int temp = 0;
        for(int i =0 ; i<land.length ;i++){
            max=0;
            for(int j = 0; j<4;j++){
                if(index!=j){
                    if(land[i][j]>max){
                        max = land[i][j];
                        temp = j;
                    }else if(land[i][j]==max){
                        if(i<land.length-1){
                            if(land[i+1][temp]>land[i+1][j]){
                                temp = j;
                            }
                        }
                    }
                }
            }
            index = temp;
            answer +=max;
        }

        return answer;
    }
}
