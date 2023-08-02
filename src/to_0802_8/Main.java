package to_0802_8;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    //getTime - 시간을 분으로 통일시킴 
    static int getTime(String time){
        int H = Integer.valueOf(time.split(":")[0]);
        int M = Integer.valueOf(time.split(":")[1]);
        return 60 * H + M;
    }


    public static void main(String args[]) {
        Scanner kb= new Scanner(System.in);
        
        String[] tmp = new String[5];

        int answer = 0;

        for(int i=0; i<5; i++){
            tmp[i] = kb.nextLine();
        }
        
        for(int i=0; i<5; i++){
            String st = tmp[i].split(" ")[0];
            String ed = tmp[i].split(" ")[1];

            int time = getTime(ed) - getTime(st);
            answer += time;
        }
        Queue<int[]> Q = new LinkedList<>();
        
        Q.add(new int[]{1, 2});

        System.out.println(answer );
    }
}