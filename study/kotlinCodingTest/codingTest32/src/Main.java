import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.awt.*;

import java.io.*;
import java.util.*;
public class Main {


    public static class Node{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }


    static ArrayList<String> list ;
    static ArrayList<ArrayList<Node>> graph;
    static boolean [] visited;
    static int [] dist;

    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        int V = scanner.nextInt(); // 노드의 갯수
        int E = scanner.nextByte(); // 간선의 갯수
        int startIdx = scanner.nextInt();
        graph=  new ArrayList<>();
        visited = new boolean[V+1];
        dist = new int[V+1];
        for(int i =0; i<V+1 ; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0 ; i <E ; i++){
            int num = scanner.nextInt();
            int num2 = scanner.nextInt();
            int cost = scanner.nextInt();

            graph.get(num).add(new Node(num2,cost));

        }
        for(int i=0; i<V+1;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[startIdx]=0;

        for(int i = 0 ; i<V;i++){

            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;

            for(int  j = 1 ; j<V+1;j++){

                if(!visited[j] && dist[j]<nodeValue){

                    
                }
            }
        }




    }



}

