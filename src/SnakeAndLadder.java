import java.util.LinkedList;
import java.util.Queue;

//pair class to keep the track of the cell and the number of moves(level)
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
        //get a connection array and store the next cell number reached as value and previous cell number as index
        // if there is no such movement(like no ladder or snake) then mark it as -1
        int[] connection = new int[31];
        for(int i=0; i<31; i++){
            connection[i]= -1;
        }

        for(int i=0; i<2*n; i+=2){
            connection[arr[i]] = arr[i+1];
        }

        //start a pair from first cell and with no movement
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(1,0);
        q.add(p);

        while(!q.isEmpty()){
            Pair qp = q.remove();
            int currCell = qp.cell;
            int currLevel = qp.level;

            //if my final cell reached then return its level(which is basically moves)
            if(currCell == 30){
                return currLevel;
            }
            //otherwise check the next 6 moves of the dice, if its getting out of bound then break
            //else if no drastic move possible then store the index(which is current cell +move) and add 1 to count(level)
            //else just add the future cell number and the level carried forward
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
