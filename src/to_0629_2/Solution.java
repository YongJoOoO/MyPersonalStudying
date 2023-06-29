package to_0629_2;

import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int answer = 0;
    static boolean[][] visited;
    //상하좌우 
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    //bfs
    static void bfs(int x, int y, int[][] maps){
        Queue<int[]> Q = new LinkedList<>();
        
        Q.add(new int[] {x, y});
        visited[x][y]= true;
        
        while(!Q.isEmpty()){
            int[] cur = Q.poll();//현재 정점
            for(int i=0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx <0 || ny <0 || nx >=maps.length||ny >= maps.length) continue;
                if(maps[nx][ny] == 0|| visited[nx][ny] == true) continue;// 방문 불가능한 벽이므로 
                //그 외에는 방문 가능 
                Q.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                maps[nx][ny] = maps[cur[0]][cur[1]] + 1;
            }
        }
    }
    
    //solution
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps.length];
        
        bfs(0, 0, maps);
        
        answer = maps[maps.length-1][maps.length-1];
        
        if(answer == 1) {//도달 못했으면 초기값1 일것이므로 
            answer = -1; //-1 리턴
        }
        
        
        return answer;
    }
}