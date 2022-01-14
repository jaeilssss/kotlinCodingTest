

import javax.naming.PartialResultException;
import java.util.ArrayList;
import java.util.HashMap;

class Solution {

    static ArrayList<String> list = new ArrayList<>();
    private static long max = 0;

    public long solution(String expression) {
        long answer = 0;
        int startIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            if(i==expression.length()-1){
                list.add(expression.substring(startIndex,i+1));
            } else if (expression.substring(i, i + 1).equals("*") ||
                    expression.substring(i, i + 1).equals("+") ||
                    expression.substring(i, i + 1).equals("-")) {
                list.add(expression.substring(startIndex, i));
                list.add(expression.substring(i, i + 1));
                startIndex = i + 1;
            }
        }

        search(new String[]{"*","+","-"});
        search(new String[]{"*","-","+"});
        search(new String[]{"+","*","-"});
        search(new String[]{"+","-","*"});
        search(new String[]{"-","+","*"});
        search(new String[]{"-","*","+"});

        return max;
    }

    public void search(String[] array) {
        ArrayList<String> temp = (ArrayList<String>) list.clone();

        for(int i = 0 ;i<array.length;i++){
            String str = array[i];

            int index=0;
            while (index!=temp.size()-1 && temp.size() != 1) {

                if (temp.get(index + 1).equals(str)) {
                    if (str.equals("*")) {

                        long num = Long.parseLong(temp.get(index)) * Long.parseLong(temp.get(index + 2));
                        temp.remove(index + 2);
                        temp.remove(index + 1);

                        temp.set(index, String.valueOf(num));


                    } else if (str.equals("+")) {
                        long num = Long.parseLong(temp.get(index)) + Long.parseLong(temp.get(index + 2));
                        temp.remove(index + 2);
                        temp.remove(index + 1);

                        temp.set(index, String.valueOf(num));


                    } else {
                        long num = Long.parseLong(temp.get(index)) - Long.parseLong(temp.get(index + 2));
                        temp.remove(index + 2);
                        temp.remove(index + 1);

                        temp.set(index, String.valueOf(num));
                    }
                } else {
                    index += 2;
                }
            }


        }
        max = Math.max(max,Math.abs(Long.parseLong(temp.get(0))));
        }


        public static void main(String [] args){
        Solution solution = new Solution();

        System.out.println(solution.solution("100-200*300-500+20"));
        }
}