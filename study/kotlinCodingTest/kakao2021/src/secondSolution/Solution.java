package secondSolution;

import java.util.ArrayList;

class Solution {

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

        System.out.println(list.length);
        System.out.println(str);
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
    private static String conversion(int number, int n){
        StringBuilder sb = new StringBuilder();

        while(number > 0){
            if(number % n < 10){
                sb.append(number % n);
            } else {
                sb.append((char)(number % n - 10 + 'A'));
            }
            number /= n;
        }

        return sb.reverse().toString();
    }
    public static void main(String [] args){


        System.out.println(
                new Solution().solution(9000009,10)
        );
    }
}

