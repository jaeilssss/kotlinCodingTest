import sun.lwawt.macosx.CSystemTray;

import java.util.Comparator;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for(int i = 0 ; i<numbers.length ; i++){
          String binary =  Long.toBinaryString(numbers[i]);
                if(numbers[i]%2==0){
                    answer[i] = numbers[i]+1;
                }else{
                    int lastIndex = binary.lastIndexOf("0");
                    int firstIndex = binary.indexOf("1",lastIndex);

                    // 0이 없는경우
                    if(lastIndex==-1){
                        binary = Long.toBinaryString(numbers[i]+1);
                        binary = binary.substring(0,2)
                                +binary.substring(2,binary.length()).replace("0","1");

                    }else{
                        binary = binary.substring(0,lastIndex)
                                +"1"
                                +binary.substring(lastIndex+1,firstIndex)
                                +"0"
                                +binary.substring(firstIndex+1,binary.length());
                    }

                    answer[i]=Long.parseLong(binary,2);
                }

            }

        return answer;
    }

    public static void main(String [] args){
        Solution solution = new Solution();

        long [] data = solution.solution(new long[]{2,7});

        for(int i=0; i<data.length ; i++){
            System.out.println(data[i]);
        }
    }
}
