package to_0802_9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
    static int N;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean[][] visited;
    static int[][] map;
    static ArrayList<Integer> arr= new ArrayList<>();//각 블록 내 장애물 개수 담기 
 
    static void BFS(int x, int y){
        int ans = 1;//현재지점 

        Queue<int[]> Q = new LinkedList<>();

        visited[x][y] = true;
        Q.add(new int[] {x, y});
        
        while(!Q.isEmpty()){
            int[] cur = Q.poll();
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx < 0 || ny <0 || nx >=N || ny >=N) continue;
                if(visited[nx][ny] == true || map[nx][ny] == 0) continue;
                
                ans++;
                visited[nx][ny] =true;
                Q.add(new int[] {nx, ny});
            }
        }

        arr.add(ans);
        
    }

    public static void main(String args[])  throws IOException{

        Scanner kb= new Scanner(System.in);

        N = kb.nextInt();
        
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0; i<N; i++) {
        	for(int j =0; j<N; j++) {
        		map[i][j]= kb.nextInt();
        	}
        }
        

        

        int sum = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(! visited[i][j] && map[i][j] == 1){//방문 전이면서 1인 지점에 대하여 BFS탐색 시도 
                    BFS(i, j);
                    sum++; //여기서 총 블록수. 순회하고 복귀하면 한 덩어리 만들어지니까 
                }
            }
        }

        System.out.println(sum);

        Collections.sort(arr);
        for(int x : arr){
            System.out.println(x);
        }

    }
}