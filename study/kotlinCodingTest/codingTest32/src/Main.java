import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.awt.*;

import java.io.*;
import java.util.*;
public class Main {


    static ArrayList<String> list ;
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

         String str = scanner.next();

         list = new ArrayList<>();

         int startIndex=0;
        int start=0;
         for(int i = 0 ; i<str.length() ; i++){

             if(str.substring(i,i+1).equals("+")){
                list.add(str.substring(startIndex,i));
                list.add(str.substring(i,i+1));
                startIndex = i+1;

             }else if(str.substring(i,i+1).equals("-")){
                 list.add(str.substring(startIndex,i));
                 list.add(str.substring(i,i+1));
                 startIndex = i+1;
             }
             if(i==str.length()-1){
                 list.add(str.substring(startIndex,i+1));

             }
         }


         while (true){
             if(start==list.size()-1) break;
             if(list.get(start+1).equals("+")){
                 int num = Integer.parseInt(list.get(start))+Integer.parseInt(list.get(start+2));
                 list.set(start,String.valueOf(num));
                 list.remove(start+2);
                 list.remove(start+1);

             }else{
                 start+=2;
             }
         }
        int sum = Integer.parseInt(list.get(0));
         for(int  i = 2 ; i<list.size() ; i+=2){
             sum -=Integer.parseInt(list.get(i));
         }

         System.out.println(sum);

    }



}

