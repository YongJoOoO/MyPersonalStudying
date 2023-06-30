package to_0630_7;

import java.util.*;

class Solution {
    static boolean[] visited;
    
    static void bfs(int v, int[][] computers){
        Queue<Integer> Q = new LinkedList<>(); 
        Q.add(v);
        visited[v] = true;
        
        while(!Q.isEmpty()){
            int cur = Q.poll();
            for(int i=0; i<computers.length; i++){
                if(computers[v][i] == 1 && !visited[i]){
                    Q.add(i);
                    visited[i] =true;
                }
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                answer++;
                bfs(i, computers);
            }
        }
        
        return answer;
    }
}