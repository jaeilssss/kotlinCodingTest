
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuffer answer = new StringBuffer();
        int num=1;
        int count=0;
        int index =1;
        StringBuffer str = new StringBuffer();
        str.append("0");
        while (str.toString().length()<t*m){
            String temp = conversion(num++,n);
            str.append(temp);
        }
        String result= str.toString();

        while(count<t){
           index= (m*count)+p-1;
            answer.append(result.charAt(index));
            count++;
        }
        return answer.toString();
    }

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
            return sb.reverse().toString();

    }

    public static void main(String [] args){
        System.out.println(new Solution().solution(2,4,2,1));
    }
}