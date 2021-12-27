import com.sun.org.apache.xerces.internal.xs.StringList;
import sun.jvm.hotspot.code.ScopeValue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {




    public static class Info implements Comparable<Info>{
        int count;
        int index;
        int num;

        public Info(int count, int index, int num) {
            this.count = count;
            this.index = index;
            this.num = num;
        }

        @Override
        public int compareTo(Info o) {
            if(this.count==o.count){
                return this.index-o.index;
            }
            return this.count-o.count;
        }
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Info> list = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int  i = 0 ;i<m; i++){
            int num = scanner.nextInt();
            boolean flag = false;
            if(list.size()!=n){
                for(int j= 0 ; j<list.size() ; j++){
                    if(list.get(j).num==num) {
                        list.get(j).count++;
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    list.add(new Info(1,i,num));
                }

            }else{
                for(int j= 0 ; j<list.size() ; j++){
                    if(list.get(j).num==num) {
                        list.get(j).count++;
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    Collections.sort(list);

                    list.remove(0);
                    list.add(new Info(1,i,num));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int  i=0; i<list.size() ; i++){
            answer.add(list.get(i).num);
        }
        Collections.sort(answer);
        for(int i = 0 ; i<answer.size();i++){
            sb.append(answer.get(i)+" ");
        }
        System.out.println(sb.toString());
    }

}
