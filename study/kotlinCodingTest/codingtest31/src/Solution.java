import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
         Arrays.sort(A);
        Arrays.sort(B);

        int leftIndex = 0;
        int rightIndex = B.length-1;

        while(true){
            if(leftIndex==A.length){
                break;
            }else{
                answer = answer+(A[leftIndex++]*B[rightIndex--]);

            }
        }
        return answer;
    }


    public void merge(){



    }
    public static void main(String[] args){
        System.out.println(new Solution().solution(
                new int[]{1,4,2},
                new int[]{5,4,4}
        ));
    }
}

