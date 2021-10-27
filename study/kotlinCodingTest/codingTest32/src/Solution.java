class Solution {
    Boolean [] visited ;
    int num;
    int [][] dungeonsArray;
    public int solution(int k, int[][] dungeons) {

        dungeonsArray = dungeons;
        visited = new Boolean[dungeons.length];
        for(int i = 0; i <dungeons.length ; i++){
            visited[i] = false;
        }
        search(0,k);
        return num;
    }

    public void search(int count,int size){
        
        for(int i = 0; i<dungeonsArray.length ; i++){
            int temp = size;
            if(temp>=dungeonsArray[i][0] && !visited[i]){
                temp -=dungeonsArray[i][1];

                visited[i]=true;
                search(count+1,temp);
                visited[i]=false;

            }

        }
        num = Math.max(num,count);

    }

    public static void main(String []  args){
    Solution solution = new Solution();
        System.out.println(solution.solution(80,new int[][]{{80,20},{50,40},{30,10},{10,10}}));
    }
}
