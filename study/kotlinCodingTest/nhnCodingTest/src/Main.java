

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    ArrayList<Integer> list = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    public void test(){
        ArrayList[] arrayLists = new ArrayList[20];
        String str = "dddddd2e32";
       char[] array =  str.toCharArray();
       array[0]='d';

        Boolean test=  false;
        Collections.sort(list);
      int max=   Collections.max(list);
      int index =list.indexOf(max);

        list.remove(0);
    }
}
