import java.util.Scanner;

class Solution {

    public static void main(String []  args){

        Scanner scanner = new Scanner(System.in);
        boolean check = false;

        int num = scanner.nextInt();
        String []str = new String[num];
        for(int  i = 0 ; i<num ; i++){
            str[i] = scanner.next();
        }
        int index = str[0].length()-1;

        while (!check){


        for(int i = 0; i<num;i++){
            String temp = str[i].substring(index,str[0].length());

            for(int  j = 0 ; j<num; j++){
                if(i!=j){
                    if(temp.equals(str[j].substring(index,str[0].length()))){
                        check = true;
                        break;
                    }
                }

            }
        }

        if(check){
            check= false;
            index--;
        }else{
            System.out.println(str[0].length()-index);
            break;
        }
    }
    }

}

