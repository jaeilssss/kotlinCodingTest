import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.awt.*;

import java.io.*;
import java.util.*;
public class Main {

    static int n ;
    static ArrayList<Integer> [] graph;
    static boolean [] visited;
   static ArrayList<Integer> answer;
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

         n = scanner.nextInt();

         graph = new ArrayList[n+1];
        visited = new boolean[n+1];
         answer = new ArrayList<>();
         for(int i = 0 ; i<n+1 ; i++){
             graph[i] = new ArrayList<>();
         }
         for(int i= 0 ; i<n-1;i++){
             int node1 = scanner.nextInt();
             int node2 = scanner.nextInt();

             graph[node1].add(node2);
             graph[node2].add(node1);
         }

         for(int i = 0 ;i<n+1 ; i++){
             answer.add(-1);
         }
        dfs(1);
        for(int  i = 2 ; i<n+1; i++){
            System.out.println(answer.get(i));
        }
    }

    public static void dfs(int node){
        visited[node] = true;

        for(int  i = 0 ;i<graph[node].size();i++){
            int num = graph[node].get(i);

            if(!visited[num]&&num!=1){
                answer.set(num,node);
                visited[num]=true;

                    dfs(num);


            }

        }


    }

}

