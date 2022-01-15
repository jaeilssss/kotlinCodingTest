import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.awt.*;

import java.io.*;
import java.util.*;
public class Main {

    static class Node{
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    static ArrayList<Integer>[] array;
    static ArrayList<Boolean> visited;
    static ArrayList<Integer> answer;
    public static void main(String [] args){

        Scanner scanner=  new Scanner(System.in);
        answer = new ArrayList<>();
        int n;
        int m;
        int k;
        int x;
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        x = scanner.nextInt();
        array = new ArrayList[n+1];
        visited = new ArrayList<>();
        for(int  i = 0 ;i<n+1;i++){
            visited.add(false);
            array[i] = new ArrayList<>();
        }

        for(int  i = 0 ; i<m;i++){
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            array[start].add(end);
        }

        bfs(x,k);
        if(answer.size()==0){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int i = 0 ;i<answer.size();i++) System.out.println(answer.get(i));
        }


    }
    public static void bfs(int start, int k){


        LinkedList<Node> queue = new LinkedList<>();
        visited.set(start,true);
        queue.add(new Node(start,0));
        while (queue.size()!=0){

            Node node= queue.poll();

            if(node.cost==k){
                answer.add(node.num);
            }else{
                for(int  i =0 ; i<array[node.num].size();i++){
                    if(!visited.get(array[node.num].get(i))){
                        queue.add(new Node(array[node.num].get(i),node.cost+1));
                        visited.set(array[node.num].get(i),true);
                    }
                }
            }

        }
    }
}