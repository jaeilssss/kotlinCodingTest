import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;

import javax.swing.text.Style;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        String temp="";
        for(int  i = str.length()-1;i>=0;i--){
            temp +=str.substring(i,i+1);
        }
        if(temp.equals(str)){
            System.out.println(temp.length());
            return;
        }
        int min=1000;
        for(int  i = str.length()-2 ; i>=0; i--){
             temp = str;
            for(int j = i; j>=0;j--){
                temp+=str.substring(j,j+1);
            }
            boolean result = check(temp);
            if(result){
                min = Math.min(min,temp.length());
            }
        }

        System.out.println(min);
    }

    public static boolean check(String str){
        String temp = "";
        for(int j = str.length()-1 ; j>=0;j--){
            temp +=str.substring(j,j+1);
        }

        if(str.equals(temp)){
            return true;
        }else{
            return false;
        }
    }
}