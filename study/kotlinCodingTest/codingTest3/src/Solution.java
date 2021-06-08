public class Solution {
    public int solution(int n) {
        int answer =n-1;
        int root=(int)Math.sqrt(n);
        int [] array = new int[n+1];
        for(int i = 0 ; i<=n ; i++){
            if(i==2){
                array[i]=-1;
            }
            array[i]=0;
        }
        for(int i=2; i<=root ; i++){
            for (int  j = i; j*i<=n ;j++){
                array[j*i]=-1;
            }
        }
        for(int  i = 2 ;i<=n ; i++){
            if(array[i]==-1){
                answer--;
            }
        }
        return answer;
    }
}


