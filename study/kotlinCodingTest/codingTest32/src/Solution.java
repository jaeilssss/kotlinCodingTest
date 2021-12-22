import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

         Arrays.sort(info);

        for(int  i =0 ; i<query.length ; i++){

            int count = 0;

            String [] queryArray = query[i].split(" ");

            for(int  j = 0 ; j<info.length;j++){

                String [] array = info[j].split(" ");
                boolean check =true;
                if(!queryArray[0].equals("-")){
                    if(!queryArray[0].equals(array[0])){
                        check = false;
                    }else if(array[0].compareTo(queryArray[0]) <0){
                        break;
                    }
                }
                if(!queryArray[2].equals("-") && check){
                    if(!queryArray[2].equals(array[1])){
                        check = false;
                    }else if(array[1].compareTo(queryArray[2])<0){
                        break;
                    }
                }
                if(!queryArray[4].equals("-")&& check){
                    if(!queryArray[4].equals(array[2])){
                        check = false;
                    }else if(array[2].compareTo(queryArray[4])<0){
                        break;
                    }

                }
                if(!queryArray[6].equals("-")&& check){
                    if(!queryArray[6].equals(array[3])){
                        check = false;
                    }else if(array[3].compareTo(queryArray[6])<0){
                        break;
                    }


                }
                if(!queryArray[7].equals("-")&& check){
                    int a = Integer.parseInt(queryArray[7]);
                    int b = Integer.parseInt(array[4]);

                    if(b<a){
                        check = false;
                    }
                }
                if(check){
//                    System.out.println(info[j]);
                    count++;
                }

            }
//            System.out.println("00000--------");
            answer[i]=count;


        }

        return answer;
    }

}