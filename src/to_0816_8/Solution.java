package to_0816_8;
//집으로 가자 | RE 또 풀이
import java.util.*;
class Solution {
	//솔루션 함수 
	public int solution(int[] pool, int a, int b, int home){
		int[][] ch = new int[2][10001];
		for(int x : pool) {
			ch[0][x] = 1;
			ch[1][x] = 1;
		}
		
		Queue<int[]> Q = new LinkedList<>();
		ch[0][0] = 1;
		ch[1][0] = 1;
		Q.add(new int[] {0, 0});
		
		int lv = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len; i++) {
				int[] cur = Q.poll();
				int dx = cur[0];//좌표 정보
				int ctr = cur[1];//0 or 1 점프 정보
				
				if(dx == home) return lv;//여기서 정답체크
				//1) a로 점프하기 
				int nx = dx + a;
				if(nx <= 10001 && ch[0][nx] == 0) {
					ch[0][nx]  = 1;//앞으로 갔다고 체크
					Q.add(new int[] {nx, 0});
				}
				
				//2) b로 점프하기
				nx = dx - b;
				if(nx >= 0 && ch[1][nx] == 0 && ctr == 0) {
					ch[1][nx] = 1;
					Q.add(new int[] {nx, 1});
				}
			}
			//레벨 플플
			lv++;
		}
		return -1;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));	
		System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));	
		System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));	
		System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));	
		System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));	
	}
}