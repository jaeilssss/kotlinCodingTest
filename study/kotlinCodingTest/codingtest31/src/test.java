import com.sun.source.tree.Tree;


import java.util.Scanner;
import java.util.HashMap;
class test {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String , Integer> map = new HashMap<>();

        for(int  i = 0 ; i<phone_book.length ; i++){
            map.put(phone_book[i],i);
        }

         for(int i = 0; i<phone_book.length ; i++){
            for(int j = 1 ; j<phone_book[i].length() ; j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        return answer;
    }
    public static  void main(String [] args){

        System.out.println(new test().solution(new String[]{"9999999000000","9900000000000000000","99"}));
    }
}


