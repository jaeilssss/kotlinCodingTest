class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int  i = 0 ; i<arr1.length ; i++){
            StringBuilder first = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder second = new StringBuilder(Integer.toBinaryString(arr2[i]));
            int index = 0;
            while (true){
                if(index==n){
                    break;
                }else{
                    if(first.length()!=n){
                        first.insert(0, "0");
                    }
                    else if(second.length()!=n){
                        second.insert(0, "0");
                    } else{
                        if(first.charAt(index)=='1' || second.charAt(index)=='1'){

                            if(answer[i]==null){
                                answer[i] = "#";
                            }else{
                                answer[i] = answer[i]+"#";
                            }
                        }else{
                            if(answer[i]==null){
                                answer[i] = " ";
                            }else{
                                answer[i] = answer[i]+" ";
                            }
                        }
                        index++;
                    }

                }
            }
        }
        return answer;
    }

    public static void main(String []  args){
        int num = 20;

        Solution solution = new Solution();

        String [] test = solution.solution(6, new int[]{46, 33, 33 ,22, 31, 50},new int[]{27 ,56, 19, 14, 14, 10});
        for(int  i =0 ; i<test.length ; i++){
            System.out.println(test[i]);
        }
    }
}

