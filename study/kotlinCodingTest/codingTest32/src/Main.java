import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        int answer = 0;

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int length = scanner.nextInt();
        int count = n;
        char [] array = scanner.next().toCharArray();

        for(int i = 1; i<length-1; i++){

            if(array[i-1]=='I' && array[i]=='O' && array[i+1]=='I'){
                count--;
                if(count==0){
                    answer++;
                    count++;
                }
                i++;
            }else{
                count=n;
            }

        }


        System.out.println(answer);

    }
}
