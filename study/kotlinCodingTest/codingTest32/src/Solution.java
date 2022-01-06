import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
    int[] answer = {};

    static class Person {
        int x;
        int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(String[][] places) {

        answer = new int[places.length];
        String str ;
        for (int i = 0; i < places.length; i++) {
            char[][] array = new char[7][7];
            ArrayList<Person> list = new ArrayList<>();
            array[0] = new char[]{'X', 'X', 'X', 'X', 'X','X','X'};

            str = "X"+places[i][0]+"X";
            array[1] = str.toCharArray();

            str = "X"+places[i][1]+"X";
            array[2] = str.toCharArray();

            str = "X"+places[i][2]+"X";
            array[3] = str.toCharArray();

            str = "X"+places[i][3]+"X";
            array[4] = str.toCharArray();

            str = "X"+places[i][4]+"X";
            array[5] = str.toCharArray();

            array[6] = new char[]{'X', 'X', 'X', 'X', 'X','X','X'};
            for (int j = 1; j < 6; j++) {
                if (array[j][1] == 'P') list.add(new Person(j, 1));
                if (array[j][2] == 'P') list.add(new Person(j, 2));
                if (array[j][3] == 'P') list.add(new Person(j, 3));
                if (array[j][4] == 'P') list.add(new Person(j, 4));
                if (array[j][5] == 'P') list.add(new Person(j, 5));
            }

            int result = bfs(array,list);
            answer[i]=result;


        }
        return answer;
    }

    public static int bfs(char[][] array, ArrayList<Person> list) {
        int check = 1;
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            LinkedList<Person> queue = new LinkedList<>();
            int x = person.x;
            int y = person.y;
            if(array[x-1][y]=='P') return 0;
            if(array[x+1][y]=='P') return 0;
            if(array[x][y-1]=='P') return 0;
            if(array[x][y+1]=='P') return 0;
            if (array[x - 1][y] == 'O') queue.add(new Person(x - 1, y));
            if (array[x][y - 1] == 'O') queue.add(new Person(x, y - 1));
            if (array[x + 1][y] == 'O') queue.add(new Person(x + 1, y));
            if (array[x][y + 1] == 'O') queue.add(new Person(x, y + 1));
            while (queue.size() != 0) {
                Person temp = queue.poll();
                int tempX = temp.x;
                int tempY = temp.y;
                if ((tempX - 1) != x && array[tempX - 1][tempY] == 'P') {
                    return 0;
                }
                if ((tempX + 1) != x && array[tempX + 1][tempY] == 'P') {
                    return 0;
                }
                if ((tempY - 1) != y && array[tempX][tempY - 1] == 'P') {
                    return 0;
                }
                if ((tempY + 1) != y && array[tempX][tempY + 1] == 'P') {
                    return 0;
                }


            }
        }

        return check;
    }

    public static void main(String [] args){
        Solution solution = new Solution();

        int [] result = solution.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
        {"OOOPX", "OXPXX", "OXXXO", "OXXXO", "OOOXX"},
        {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
        {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}

        });
        for(int i =0 ; i<result.length ; i++){
            System.out.print(result[i]);
        }
    }
}