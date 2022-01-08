import com.sun.scenario.effect.impl.sw.java.JSWColorAdjustPeer;
import sun.security.util.Password;

import javax.swing.text.Style;


import java.awt.*;
import java.util.*;
import java.io.*;
public class Main {
    static String S;
    static String T;
    public static class PostIt {
        int tableNum;
        int time;

        public PostIt(int tableNum, int time) {
            this.tableNum = tableNum;
            this.time = time;
        }


    }
    public static void main(String [] args) throws IOException {

        Scanner scanner = new Scanner(System.in);


        String first  = scanner.nextLine();
        int n = Integer.parseInt(first.split(" ")[0]);
        ArrayList<String> order = new ArrayList<>();
        ArrayList<PostIt> list=  new ArrayList<>();
        for(int i = 0; i<n;i++){
            String str = scanner.nextLine();
            order.add(str);

        }

        for(int i = 0 ; i<order.size() ; i++){
            String [] input = order.get(i).split(" ");

            if(input[0].equals("order")){
                list.add(new PostIt(Integer.parseInt(input[1]),Integer.parseInt(input[2])));
            }else if(input[0].equals("sort")){
                Collections.sort(list, new Comparator<PostIt>() {
                    @Override
                    public int compare(PostIt o1, PostIt o2) {
                        if(o1.time==o2.time){
                            return o1.tableNum-o2.tableNum;
                        }else{
                            return o1.time-o2.time;
                        }
                    }
                });

            }else if(input[0].equals("complete")){
                for(int  j=0; j<list.size();j++){
                    if(list.get(j).tableNum==Integer.parseInt(input[1])){
                        list.remove(j);
                    }
                }
            }

            if(list.size()!=0){
                for(int j = 0 ;j<list.size();j++){
                    System.out.print(list.get(j).tableNum+" ");
                }
                System.out.println();
            }else{
                System.out.println("sleep");
            }
        }


    }

}