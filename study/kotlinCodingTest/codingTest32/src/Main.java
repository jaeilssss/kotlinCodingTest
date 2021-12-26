import sun.jvm.hotspot.code.ScopeValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    static int [][] arr ;
    static int n;
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);


        n = scanner.nextInt();
        int answer=1;
        arr = new int[n][2];

        for(int i= 0 ; i<n;i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            arr[i][0]=start;
            arr[i][1]=end;
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1]-o2[1];
            }
        });

     int index = 0;
    for(int i =1; i<n;i++){
        if(arr[index][1]<=arr[i][0]){
            answer++;
            index=i;
        }
    }

    System.out.println(answer);
    }
}
