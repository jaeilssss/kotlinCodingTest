import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
public class Main {
    static String S;
    static String T;
    public static void main(String [] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        S = scanner.next();
        T = scanner.next();

        if(fx(S,T)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }

    public static boolean fx(String s , String t){
        boolean check =false;
        if(s.length()==t.length()){
            return s.equals(t);
        }

        if(t.charAt(t.length()-1)=='A' ){
           check =  fx(s,t.substring(0,t.length()-1));
        }

        if(t.charAt(0)=='B' && !check){
            StringBuilder sb = new StringBuilder(t.substring(1,t.length()));
            sb.reverse();

            check = fx(s,sb.toString());
        }
        return check;
    }

}