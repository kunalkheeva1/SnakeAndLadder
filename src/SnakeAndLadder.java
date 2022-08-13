import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int cell;
    int level;
    Pair(int cell, int level){
        this.cell = cell;
        this.level = level;
    }
}



public class SnakeAndLadder {

    // n denotes number of snakes and ladders,
    // int [] arr contains their subsequent combinations
    static int snakeAndLadder(int n, int []arr){
        int[] connection = new int[31];
        for(int i=0; i<31; i++){
            connection[i]= -1;
        }

        for(int i=0; i<2*n; i+=2){
            connection[arr[i]] = arr[i+1];
        }
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(1,0);
        q.add(p);

        while(!q.isEmpty()){
            Pair qp = q.remove();
            int currCell = qp.cell;
            int currLevel = qp.level;

            if(currCell == 30){
                return currLevel;
            }
            for(int i=currCell+1; i<currCell+6; i++){

                if(currCell>30){
                    break;
                }
                if(connection[i]==-1){
                    Pair p1 = new Pair(i, currLevel+1);
                    q.add(p1);
                }
                else{
                    Pair p2 = new Pair(connection[i],currLevel+1 );
                    q.add(p2);
                }


            }


        }return -1;
    }

    public static void main(String[] args) {

    }
}
