import sun.security.jgss.GSSCaller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    private static int K;
    private static int N;
    private static int[][] array;
    private static boolean[] robot;

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        int count=1;
        int zeroCount=0;
        robot = new boolean[N];
        array = new int[N*2][2];

        for(int i = 0 ; i<N*2; i++){
            array[i][0]= scanner.nextInt();
        }

        while (true){
            boolean flag = false;
             zeroCount = 0;


            for(int i = 0 ; i<N*2;i++){
                if(i==N*2-1){
                    array[0][1]=array[i][0];
                }else{
                    array[i+1][1] = array[i][0];

                }
            }
            for(int i =N-1 ; i>=0;i--){
                    if(i==N-1) {
                        robot[i]=false;
                    } else if(robot[i]){
                        robot[i+1]=true;
                        robot[i]=false;
                    }

            }
            for(int i= 0 ; i<N*2;i++){
                array[i][0] = array[i][1];
            }



            for(int i =N-1 ; i>=0;i--){
                if(i==N-1){
                    robot[i]=false;
                }else{
                    if(robot[i] && array[i+1][0]!=0&& !robot[i + 1]){
                        robot[i] =false;
                        robot[i+1] = true;
                        array[i+1][0]--;
                    }
                }
            }

            if(array[0][0]!=0){
                array[0][0]--;
                robot[0]=true;
            }

            for(int  i = 0 ; i<array.length ; i++){
                if(array[i][0]==0){
                    zeroCount++;
                    if(zeroCount>=K) flag =true;
                }
            }

            if(flag) break;
            count++;


        }
        System.out.println(count);

    }
}