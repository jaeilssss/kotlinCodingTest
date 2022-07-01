

import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

    public static void main(String [] args){

        LinkedList[] linkedList = new LinkedList[8];


        for(int i = 0; i<8; i++){
            linkedList[i] = new LinkedList<Integer>();
        }

        linkedList[0].add(1);
        linkedList[0].add(2);
        linkedList[1].add(3);
        linkedList[1].add(4);
        linkedList[2].add(5);
        linkedList[2].add(6);
        linkedList[3].add(7);

        bfs_list(0,linkedList,new boolean[8]);

    }

    public static void bfs_list(int v , LinkedList[] linkedList , boolean [] visited){

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(v);
    }
}
