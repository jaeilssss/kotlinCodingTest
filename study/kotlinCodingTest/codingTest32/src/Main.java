import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.awt.*;

import java.io.*;
import java.util.*;
public class Main {


    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int area=1;
        int  [][] arr = new int[n][m];


        for(int i = 0 ;i<n;i++){
            String str = scanner.next();
            for(int j= 0;j<m;j++){
                arr[i][j]=Integer.parseInt(str.substring(j,j+1));
            }
        }


        for(int i=0;i<n;i++){

            for(int j =0; j<m-1; j++){
                for(int k=1; k<m;k++){
                    if(i+k<n && j+k<m &&
                    arr[i][j]==arr[i][j+k]
                    &&arr[i][j+k]==arr[i+k][j]
                    &&arr[i+k][j+k]==arr[i][j]){
                        area = Math.max(area,(k+1)*(k+1));
                    }
                }
            }
        }

        System.out.print(area);
    }
}