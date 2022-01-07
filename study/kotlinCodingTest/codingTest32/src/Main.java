import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class Main {
    static String S;
    static String T;
    public static void main(String [] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();
        String temp="";
        boolean isTag= false;
        for(int i = 0 ; i<str.length();i++){

            if(str.substring(i, i + 1).equals("<")){
                if(temp.length()!=0){
                    StringBuilder sb = new StringBuilder(temp);
                    sb.reverse();
                    list.add(sb.toString());
                    temp =str.substring(i,i+1);
                    isTag = true;
                }else{
                    temp +=str.substring(i,i+1);
                    isTag = true;
                }
            } else if(str.substring(i, i + 1).equals(">")){
                temp +=str.substring(i,i+1);
                list.add(temp);
                temp="";
                isTag = false;
            }else if(str.substring(i, i + 1).equals(" ")){
                if(temp.length()!=0 && !isTag){
                    StringBuilder sb = new StringBuilder(temp);
                    sb.reverse();
                    list.add(sb.toString());
                    list.add(" ");
                    temp="";
                }else{
                    temp +=str.substring(i,i+1);
                }
            }else{
                temp +=str.substring(i,i+1);
            }
        }
        if(temp.length()!=0) {
            StringBuilder sb = new StringBuilder(temp);
            sb.reverse();
            list.add(sb.toString());
        }
        for(int i = 0; i<list.size();i++){
            System.out.print(list.get(i));
        }
    }


}