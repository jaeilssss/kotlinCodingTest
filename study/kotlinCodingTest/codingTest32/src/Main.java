import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.awt.*;

import java.io.*;
import java.util.*;
public class Main {

   static int n;
    static int [] array;
    static long sum=0;
    public static void main(String [] args){

        Scanner scanner=  new Scanner(System.in);

        n = scanner.nextInt();

        array= new int[n];

        for(int i = 0; i<n;i++){
            int num = scanner.nextInt();
            array[i] = num;
        }
        Arrays.sort(array);
        for(int i=0;i<n;i++){
            if(array[i]!=i+1){
                sum+=Math.abs( array[i]-(i+1));
            }
        }

        System.out.println(sum);
    }
}