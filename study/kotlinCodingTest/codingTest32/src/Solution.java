import java.util.ArrayList;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Character> list = new ArrayList<>();
        char [] chars = skill.toCharArray();
        for(int i = 0 ; i<chars.length; i++){
            list.add(chars[i]);
        }
        for(int  i = 0 ; i<skill_trees.length ; i++){
            char [] charArray = skill_trees[i].toCharArray();
            int index = 0;
            boolean check = true;
            for(int j =0 ; j<charArray.length; j++){
                if(list.contains(charArray[j])){
                    if(list.indexOf(charArray[j])==index){
                        index++;
                    }else{
                        check = false;
                        break;
                    }
                }
            }
            if(check){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String [] args){
        System.out.println(
                new Solution().solution("CBD",new String[]{"BACDE","CBADF","AECB","BDA"})
        );
    }
}

