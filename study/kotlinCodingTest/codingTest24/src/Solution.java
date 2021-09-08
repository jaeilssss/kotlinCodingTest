
import java.util.ArrayList;
class Solution {

    ArrayList<Integer> list=  new ArrayList<>();
    public int solution(String dartResult) {
        int answer = 0;
        int j = 0;

        for(int i =0 ; i<3; i++){
            while (true){

                int number = Character.getNumericValue(dartResult.charAt(j++));
                if(dartResult.charAt(j)=='0'){
                    char c = dartResult.charAt(j-1);
                    c += dartResult.charAt(j++);
                    number = Character.getNumericValue(c);
                }
                char bonus = dartResult.charAt(j++);

                if(j==dartResult.length()){
                    bonusMethod(number,bonus);
                    break;
                }else if(dartResult.charAt(j)=='*' || dartResult.charAt(j)=='#'){
                    char option = dartResult.charAt(j++);
                    if(option=='*'){
                        bonusMethod(number,bonus);

                        if(i!=0){
                            list.set(i-1 , list.get(i-1)*2);
                        }
                        list.set(i,list.get(i)*2);

                    }else{
                        bonusMethod(number,bonus);
                        if(list.get(i)<0){
                            list.set(i,list.get(i)*-2);
                        }else{
                            list.set(i,list.get(i)*-1);
                        }
                    }
                    break;
                }  else{

                    bonusMethod(number,bonus);
                    break;
                }
            }
        }
        for(int a = 0; a<3; a++){
            answer += list.get(a);
        }

        return answer;
    }

    public void bonusMethod(int number , char bonus){
        if(bonus=='D'){
            number = number*number;

        }else if(bonus=='T'){
            number = number*number *number;
        }

        list.add(number);

    }
}