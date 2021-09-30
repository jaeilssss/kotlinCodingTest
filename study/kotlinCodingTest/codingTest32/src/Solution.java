import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int solution(String dirs) {

        HashMap<String,Integer> visited = new HashMap<>();

        int xPoint = 5;
        int yPoint = 5;

        for(int  i = 0 ; i<dirs.length();i++){
            if(dirs.charAt(i)=='U'){
                if(yPoint!=10){
                    String depart = String.valueOf(xPoint)+String.valueOf(yPoint);
                    yPoint++;
                    String arrive = String.valueOf(xPoint)+String.valueOf(yPoint);
                    if(visited.size()==0){
                        visited.put(depart+arrive,1);
                    } else if(!visited.containsKey(depart + arrive) && !visited.containsKey(arrive + depart)){
                        visited.put(depart+arrive,1);
                    }
                }

            }else if(dirs.charAt(i)=='D'){
                if(yPoint!=0){
                    String depart = String.valueOf(xPoint)+String.valueOf(yPoint);
                    yPoint--;
                  String arrive = String.valueOf(xPoint)+String.valueOf(yPoint);
                    if(visited.size()==0){
                        visited.put(depart+arrive,1);
                    } else if(!visited.containsKey(depart+arrive) && !visited.containsKey(arrive+depart)){
                      visited.put(depart+arrive,1);
                  }


                }

            }else if(dirs.charAt(i)=='R'){
                if(xPoint!=10){
                    String depart = String.valueOf(xPoint)+String.valueOf(yPoint);
                    xPoint++;
                    String arrive = String.valueOf(xPoint)+String.valueOf(yPoint);
                    if(visited.size()==0){
                        visited.put(depart+arrive,1);
                    } else if(!visited.containsKey(depart+arrive) && !visited.containsKey(arrive+depart)){
                        visited.put(depart+arrive,1);
                    }
                }

            }else{
                if(xPoint!=0){
                    String depart = String.valueOf(xPoint)+String.valueOf(yPoint);
                    xPoint--;
                    String arrive = String.valueOf(xPoint)+String.valueOf(yPoint);
                    if(visited.size()==0){
                        visited.put(depart+arrive,1);
                    } else if(!visited.containsKey(depart+arrive) && !visited.containsKey(arrive+depart)){
                        visited.put(depart+arrive,1);
                    }
                }
            }
        }


        return visited.size();
    }




    public static void main(String []  args){
        System.out.println(new Solution().solution("ULURRDLLU"));
        HashMap<String,Integer> visited = new HashMap<>();
        visited.put("gd",1);
        if(visited.containsKey("gd")){
            System.out.println("gdgd");
        }
    }
}
