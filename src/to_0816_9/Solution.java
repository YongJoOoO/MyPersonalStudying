package to_0816_9;
//송아지를 잡자 
import java.util.*;
class Solution {
	public int solution(int s, int e){
		
		//<현수, 송아지> 위치로 이동할 건데 
		//시작점 처리 
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {s, e});
		int t= 1;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len ;i++) {
				//하나의 레벨에 대하여 
				int[] cur = Q.poll();
				
				int hy = cur[0];//현재 현수 좌표 
				int sy = cur[1];//현재 송아지 좌표 
				
				//1) +1좌표로 갈 때 //다음 정점 처리 
				int nx = hy + 1;
				if(nx >= 0) {
					Q.add(new int[] {nx, sy+t});
				}
				//2) -1로 갈 떄
				nx = hy -1;
				if(nx >= 0) {
					Q.add(new int[] {nx, sy+t});
				}
				//3) *2로 갈 때
				nx = hy * 2;
				if(nx >= 0) {
					Q.add(new int[] {nx, sy+t});
				}
			}
		
		}
		
		
		return -1;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(1, 11));	
		System.out.println(T.solution(10, 3));	
		System.out.println(T.solution(1, 34567));
		System.out.println(T.solution(5, 6));	
		System.out.println(T.solution(2, 54321));	
	}
}