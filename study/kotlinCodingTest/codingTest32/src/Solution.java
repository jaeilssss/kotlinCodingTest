import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();
    HashMap<String , Integer> map = new HashMap<>();
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for(int  i = 0 ;i<orders.length ; i++){
            char [] charArrays = orders[i].toCharArray();
            Arrays.sort(charArrays);
            for(int j = 0 ; j <charArrays.length-1 ; j++){
                for(int  index = 0 ; index<course.length ; index++){
                    search(course[index],String.valueOf(charArrays[j]),charArrays , j);
                }
            }

        }

        for(int i = 0 ; i<list.size() ; i++){
            map.put(list.get(i),map.getOrDefault(list.get(i),0)+1);
        }

        List<String> keyList = new ArrayList<>(map.keySet());
        ArrayList<String> temp = new ArrayList<>();
        Collections.sort(keyList , ((o1, o2) -> (map.get(o2).compareTo(map.get(o1))))); // o1 이 더 크면 true
        for(int i = 0 ; i<course.length ; i++){
            int max = 0;
            for(int  j = 0 ; j<keyList.size() ; j++){
            if(keyList.get(j).length()==course[i] &&  map.get(keyList.get(j))>=2){
                if(max<=map.get(keyList.get(j))){
                    temp.add(keyList.get(j));
                    max = map.get(keyList.get(j));
                }

            }
            }
        }
        Collections.sort(temp);
        answer = new String[temp.size()];
        temp.toArray(answer);
        return answer;
    }

    public void search(int course , String str , char [] array,int index){
        if(str.length()==course){

            list.add(str);
        }

        for(int i = index+1 ; i<array.length; i++){
            search(course,str+String.valueOf(array[i]),array, i);
        }

    }


    public static void main(String [] args){
        String  [] str ={"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int [] counrs = {2,3,4};
       String []  data = new Solution().solution(str,counrs);
       for(int i = 0; i<data.length ; i++){
           System.out.println(data[i]);
       }
    }

}