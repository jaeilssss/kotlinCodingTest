import java.util.ArrayList;

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int col = board[0].length;
        int row = board.length;
        int [][] temp = new int[row+1][col+1];

        for(int i  =0 ; i<row;i++){
            for(int  j = 0 ; j<col ; j++){
                temp[i+1][j+1] = board[i][j];
            }
        }

        for(int  i = 1 ; i<=row ; i++) {
           for(int j = 1 ; j<=col; j++){
               if(temp[i][j]!=0){
                   temp[i][j] = Math.min(Math.min(temp[i-1][j],temp[i][j-1]),temp[i-1][j-1])+1;
                   answer = Math.max(answer,temp[i][j]);
               }
            }
        }
        return answer *answer;
    }
    public static void main(String [] args){
        System.out.println(new Solution().solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
    }
}

