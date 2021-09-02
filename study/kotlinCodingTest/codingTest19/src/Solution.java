import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack <Character>stack = new Stack();
        int size = s.length()-1;
        for(int  i =size ; i>=0 ; i--){
            if(stack.empty()){
                stack.push(s.charAt(i));
            }else{
                if(stack.peek()-s.charAt(i)==-1){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }

        if(stack.empty()){
            answer=true;
        }else{
            answer = false;
        }
        return answer;
    }
}