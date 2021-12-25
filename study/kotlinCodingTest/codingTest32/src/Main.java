import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

   static boolean[] visited ;
    static int n;
    static int m;
   static int answer = 0;
   static HashMap<Integer,Integer> map;
    static int [][] graph;
    public static void main(String [] args){

        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new HashMap<>();
        graph = new int[n][n];
        visited = new boolean[n];

        for(int i = 0 ; i<m;i++){
            int nod1 = scanner.nextInt();
            int nod2 = scanner.nextInt();

            graph[nod1-1][nod2-1]=1;
            graph[nod2-1][nod1-1]=1;

        }
        dfs(0,0);

        System.out.println(map.keySet().size());

    }


    public static void dfs(int depth , int nod){
        if(depth>=2) { return; }
        visited[nod] =true;
        for(int  i = 1; i<n;i++){
            if(graph[nod][i]==1){
                    dfs(depth+1,i);
                    map.put(i,i);
            }
        }
    }
}
