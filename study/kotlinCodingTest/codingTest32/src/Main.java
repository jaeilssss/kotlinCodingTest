import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for(int i = 0 ; i<n;i++){
            String str1 = scanner.next();
            String str2 = scanner.next();
            System.out.println(search(str1,str2));

        }

    }


    public static int search(String str1,String str2){
        int count = 0;
        char [] array1 = str1.toCharArray();
        char [] array2 = str2.toCharArray();
        for(int  i = 0 ;i<array1.length;i++){
            if(array1[i]!=array2[i]){

                for(int  j = i+1 ; j<array2.length; j++){
                    if(array1[i]==array2[j]){
                        char temp = array2[j];
                        array2[j] = array2[i];
                        array2[i]=temp;
                        count++;
                        break;
                    }else{

                        count++;
                    }

                }
            }

        }
        return count;
    }
}

