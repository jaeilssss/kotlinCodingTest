import java.util.ArrayList;
import java.util.Scanner;


public class Main {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int width =  scanner.nextInt();
        int height = scanner.nextInt();
        int myPoint;
        int myDirection;
        int n=scanner.nextInt();
        int answer=0;
        ArrayList<Integer>[] list = new ArrayList[4];

        for(int  i = 0 ; i<4;i++){
            list[i]= new ArrayList<Integer>();
        }

        for(int  i = 0 ; i<n;i++){
            int tempDirection = scanner.nextInt();
            int tempPoint = scanner.nextInt();

            list[tempDirection-1].add(tempPoint);
        }
        myDirection = scanner.nextInt();
        myDirection--;
        myPoint = scanner.nextInt();

        for(int i=0;i<4;i++){
            for(int j =0 ; j<list[i].size();j++){


                if(myDirection==i){
                    answer+=Math.abs(myPoint-list[i].get(j));
                }else{

                    if(myDirection==0){

                        if(i==1){
                            int temp = (width-myPoint)+(width-list[i].get(j));
                            int temp2 = list[i].get(j)+myPoint;
                            answer+=Math.min(temp,temp2)+height;
                        }else if(i==2){
                            answer +=myPoint+list[i].get(j);
                        }else{
                            answer +=(width-myPoint)+list[i].get(j);
                        }
                    }else if(myDirection==1){
                        if(i==0) {
                            int temp = (width-myPoint)+(width-list[i].get(j));
                            int temp2 = list[i].get(j)+myPoint;
                            answer+=Math.min(temp,temp2)+height;
                        }else if(i==2){
                            answer += myPoint+(height-list[i].get(j));
                        }else{
                            answer +=(width-myPoint)+(height-list[i].get(j));
                        }
                    }else if(myDirection==2){
                        if(i==0) {
                            answer += list[i].get(j)+myPoint;
                        }else if(i==1){
                            answer += (height-myPoint)+list[i].get(j);
                        }else{
                            int temp = myPoint+list[i].get(j);
                            int temp2 = (height-myPoint)+(height-list[i].get(j));

                            answer += Math.min(temp,temp2)+width;
                        }
                    }else{
                        if(i==0) {
                            answer += list[i].get(j)+(width-myPoint);
                        }else if(i==1){
                            answer += (height-myPoint)+list[i].get(j);
                        }else if(i==2){
                            int temp = myPoint+list[i].get(j);
                            int temp2 = (height-myPoint)+(height-list[i].get(j));

                            answer += Math.min(temp,temp2)+width;
                        }
                    }

                }


            }
        }
        System.out.println(answer);
    }
}

