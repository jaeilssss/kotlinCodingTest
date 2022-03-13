
import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

   private static ArrayList<String> answer;
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        answer = new ArrayList<>();
        int count = scanner.nextInt();
        String name = scanner.next();
        int index = name.indexOf("*");

        boolean check = true;

        for(int  i =0; i<count ; i++){
            String msg = scanner.next();
            System.out.print(msg+" ");
            int msgLastIndex = msg.length()-1;
            check = true;
            for(int j = 0 ; j<index ; j++){
                if(msg.charAt(j)!=name.charAt(j)){
                    answer.add("NE");
                    System.out.println("NE");
                    check = false;
                    break;
                }
            }
            if(check){
                for(int j = name.length()-1 ; i>index;i--){
                    if(name.charAt(j)!=msg.charAt(msgLastIndex)){
                        answer.add("NE");
                        System.out.println("NE");
                        check = false;
                        break;
                    }else{
                        msgLastIndex--;
                    }
                }
            }

            if(check){
                answer.add("DA");
                System.out.println("DA");
            }
        }

//        for(int  i = 0 ; i<answer.size() ; i++){
//            System.out.println(answer.get(i));
//        }
    }



}

