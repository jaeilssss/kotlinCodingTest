import java.util.ArrayList;

import static java.lang.System.exit;

class Solution {
    public  String conversion(int number, int N){
        StringBuilder sb = new StringBuilder();
        int current = number;

        while(current > 0){

            if(current % N < 10){
                sb.append(current % N);

            } else {
                sb.append((char)(current % N - 10 + 'A'));
            }
            current /= N;
        }
        return String.valueOf(sb.reverse());
    }
    public int solution(int n, int k) {
        int answer = 0;

        String str ="";
        if(k!=10) {
            str =  conversion(n , k);

        }else{
            str = String.valueOf(n);
        }

        boolean result = true;
        String []  list = str.split("0");

        for(int  i = 0; i<list.length ; i++){
            if(! list[i].equals("")){
                int num = Integer.parseInt(list[i]);
                if(num!=1){
                    for(int  j = 2 ; j<num ; j++){
                        if(num%j==0){
                            result  = false;
                            break;
                        }
                    }
                    if(result){
                        answer++;
                    }else{
                        result=true;
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String [] args){


        System.out.println(
                new Solution().solution(3030303,3)
        );
    }
}