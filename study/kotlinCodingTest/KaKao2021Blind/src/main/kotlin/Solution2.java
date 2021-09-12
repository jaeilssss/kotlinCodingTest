import java.util.ArrayList;
import java.util.HashMap;

class Solution2 {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

//        HashMap [] map = new HashMap[id_list.length];
////        for(int  i = 0; i < id_list.length;i++){
////            map[i] = new HashMap<String , >();
////        }

        HashMap map  = new HashMap<String , HashMap<String , String>>();
        for(int  i = 0 ;  i <id_list.length ; i++){
            map.put(id_list[i],new HashMap<String , String>());
        }

        for(int  i = 0 ;i<report.length; i++){
            String[] list = report[i].split(" ");
            HashMap temp = (HashMap) map.get(list[0]);
            temp.put(report[i],"");
            map.put(list[0],temp);
        }

        for(int i = 0 ; i<id_list.length;i++){
            HashMap temp = (HashMap) map.get(id_list[0]);
            answer[i] = temp.size();
        }

        return answer;
    }
    public static void main(String []  args){

        for(int  i = 0 ; i< 5; i++){
            String [] id_list = {"muzi", "frodo", "apeach", "neo"};
            String [] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
            System.out.println(new Solution2().solution(id_list,report,2));
        }
    }
}

