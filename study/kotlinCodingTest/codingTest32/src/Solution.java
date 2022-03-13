import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};

        HashMap<String, String> park = new HashMap<>();
        HashMap<String, Integer> feeMap = new HashMap<>();

        for(int i = 0 ; i<records.length ; i++){
            String [] input = records[i].split(" ");

            if(input[2].equals("IN")){

                park.put(input[1],input[0]);
            }else{

                String [] str = park.get(input[1]).split(":");
                String [] str2 = input[0].split(":");

                int inFee = Integer.parseInt(str[0])*60+Integer.parseInt(str[1]);
                int outFee = Integer.parseInt(str2[0])*60+Integer.parseInt(str2[1]);
                int sum = outFee - inFee;

                if(sum>fees[0]){
                    int total = ((sum-fees[0])/fees[2])*fees[3];
                    feeMap.put(input[1],feeMap.getOrDefault(input[1],0)+total+fees[1]);

                }else{
                    feeMap.put(input[1],feeMap.getOrDefault(input[1],0)+fees[1]);
                }
            park.remove(input[1]);
            }
        }
        for(String key : park.keySet()){
            System.out.println(key);
            String [] str = park.get(key).split(":");
            int inFee = Integer.parseInt(str[0])*60+Integer.parseInt(str[1]);
            int sum = 1439-inFee;
            if(sum>fees[0]){
                int total = ((sum-fees[0])/fees[2])*fees[3];
                feeMap.put(key,feeMap.getOrDefault(key,0)+total+fees[1]);

            }else{
                feeMap.put(key,feeMap.getOrDefault(key,0)+fees[1]);
            }
        }

        Object [] arrays = feeMap.keySet().toArray();
        answer = new int[arrays.length];
        Arrays.sort(arrays);
        for(int i =0 ; i<arrays.length ; i++){
            answer[i] = feeMap.get(arrays[i].toString());
            System.out.println(feeMap.get(arrays[i].toString()));
        }



        
        return answer;
    }

    public static void main(String [] args){
        Solution solution  = new Solution();

        solution.solution(new int[]{180, 5000, 10, 600},new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
    }
}


