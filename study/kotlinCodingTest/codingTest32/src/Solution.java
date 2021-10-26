import java.util.LinkedList;

class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        Boolean check = false;
        int num = n/2;
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        LinkedList<Integer> queue = new LinkedList<>();

        for(int i = 1 ; i<=n ; i++){
            queue.add(i);
        }

        while (!check){

            for(int i = 0; i<num;i++){
                int first = queue.poll();
                int second = queue.poll();

                if(first==a && second==b || first==b && second ==a){
                    check = true;
                }else{
                    if(second==a || second==b){
                        queue.add(second);
                    }else{
                        queue.add(first);
                    }
                }
            }
            num = num/2;

            answer++;
        }
        return answer;
    }



    public static void main(String []  args){
            Solution solution = new Solution();
            System.out.println(solution.solution(8,1,2));
    }
}
