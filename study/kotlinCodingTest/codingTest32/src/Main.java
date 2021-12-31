import java.util.ArrayList;

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {


    static int m;
    static int n;
    static int [][] graph;
    static int [][] visited;
    static int count=0;
    static LinkedList<Point> temp;
    public static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        m = scanner.nextInt();
        n = scanner.nextInt();

        graph = new int[n+2][m+2];
        temp = new LinkedList<>();
        boolean isZero = false;

        for(int i = 0 ; i <n+2;i++){

            for(int j=0; j<m+2;j++){
                if(i==0 || i==n+1 ||j==0 || j==m+1){
                    graph[i][j]=-1;
                }else{
                    int num = scanner.nextInt();
                    graph[i][j] = num;
                    if(num==1){
                        temp.add(new Point(i,j));
                    }
                    if(num==0){
                        isZero=true;
                    }
                }

            }
        }

        if(!isZero){
            System.out.println(0);
        }else{

            while (temp.size()!=0){

               temp =  bfs();
                count++;
            }
            isZero=false;
            for(int  i = 0 ; i<n+2; i++){
                for(int  j = 0 ;j<m+2 ; j++){
                    if(graph[i][j]==0){
                        isZero=true;
                        break;
                    }
                }
            }
            if(isZero){
                System.out.println(-1);
            }else{
                System.out.println(count-1);
            }
        }




    }

    public static LinkedList<Point> bfs(){
        LinkedList<Point> queue = new LinkedList<>();
        while (temp.size()!=0){
            Point point = temp.poll();
            if(graph[point.x][point.y+1]==0){
                graph[point.x][point.y+1]=1;
                queue.add(new Point(point.x,point.y+1));
            }
            if(graph[point.x+1][point.y]==0){
                graph[point.x+1][point.y]=1;
                queue.add(new Point(point.x+1,point.y));
            }
            if(graph[point.x-1][point.y]==0){
                graph[point.x-1][point.y]=1;
                queue.add(new Point(point.x-1,point.y));
            }
            if(graph[point.x][point.y-1]==0){
                graph[point.x][point.y-1]=1;
                queue.add(new Point(point.x,point.y-1));
            }

        }
        return queue;
    }
}

