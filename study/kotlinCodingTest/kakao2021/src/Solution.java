import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String , HashMap<String,String>> map = new HashMap<>();

       HashMap<String,Integer> receiveEmailCount = new HashMap<>();
        for(int  i = 0 ; i <id_list.length ; i++){
            receiveEmailCount.put(id_list[i],0);
            map.put(id_list[i],new HashMap());
        }

        for(int  i = 0 ; i<report.length;i++){
            String [] list = report[i].split(" ");
            HashMap<String,String> temp = map.get(list[1]);

                temp.put(list[0],list[0]);
                map.remove(list[1]);
                map.put(list[1],temp);





        }

        for(int i = 0 ; i< id_list.length ; i++){
            HashMap<String,String> temp = map.get(id_list[i]);
            if(temp.size()>=k){
                for(String key : temp.keySet()){
                    int count = receiveEmailCount.get(key);
                    count++;
                    receiveEmailCount.remove(key);
                    receiveEmailCount.put(key, count);
                }
            }
        }
        for(int i = 0; i<id_list.length ; i++){
            answer[i]=receiveEmailCount.get(id_list[i]);
        }
        return answer;
    }

    public static void main(String [] args){
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report  ={"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        for( int i = 0 ; i< id_list.length ; i++){
            System.out.println(new Solution().solution(
                id_list,
                    report,
                    2
            )[i]);
        }
    }
}

