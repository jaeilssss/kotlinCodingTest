import java.util.Scanner;

public class Solution {

public static void main(String [] args){
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    int [] arr = new int[size];
    int [] answer = new int[size];
    boolean [] visited = new boolean[size];
    for(int i =0 ; i<size; i++){
        arr[i]=scanner.nextInt();
    }
    for(int  i =0 ; i<size ; i++){
        int num = arr[i];
        int cnt=0;
       for(int j = 0 ; j<size ; j++){
           if(!visited[j]){
               if(cnt==num){
                   visited[j] = true;
                   answer[j]=i+1;
                   break;
               }
               cnt++;
           }
       }
    }

    for(int i = 0 ; i<size;i++){
        System.out.print(answer[i]+" ");
    }
}

}