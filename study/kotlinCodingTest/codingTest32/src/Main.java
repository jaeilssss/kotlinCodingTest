import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);
        int count=0;

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList <String> slist = new ArrayList<>();
        ArrayList <String> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            String temp = scanner.next();
            slist.add(temp);
        }

        for(int i = 0; i<m;i++){
            String temp = scanner.next();
            list.add(temp);
        }
        for(int  i= 0 ; i<list.size() ; i++){
            if(slist.contains(list.get(i))){
                count++;
            }
        }

        System.out.println(count);
    }
}
