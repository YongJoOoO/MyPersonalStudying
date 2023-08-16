package to_0816_7;
//집으로 가자 RE 풀이 
import java.util.*;
class Solution {
	//솔루션 
	public int solution(int[] pool, int a, int b, int home){
		boolean [][] ch = new boolean[2][10001];
		for(int x : pool) {
			ch[0][x] = true;
			ch[1][x] = true;
		}
		
		Queue<int[]> Q = new LinkedList<>();
		//시작점 처리 
		ch[0][0] = true;
		ch[1][0] = true;
		Q.add(new int[] {0, 0});
		int lv = 0;
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len; i++) {
				int[] cur = Q.poll();
				//큐에는 <좌표, 왼오> 식으로 값이 들어있기 때문에
				//cur[0] 은 좌표값
				//cur[1]에는 0 또는 1의 값이 들어있음
				//-> 0인 경우 +a로 온 값, 1인 경우 -b로 온 값인데
				//여기서 뒤쪽 b로는 두 번이상 연속 점프 불가능 함
				if(cur[0] == home) return lv;
				//cur[0]은 앞에서 온애, cur[1] 은 뒤에서 온애
				int nx = cur[0] + a;
				if(nx <= 10001 && !ch[0][nx]) {
					ch[0][nx] = true;
					Q.add(new int[] {nx, 0});
				}
				nx = cur[0] - b;
				 //cur[1] == 0 : <nx, 앞-뒤>이런 식으로 들어오는데 , 즉, cur[1] 직전에 앞으로 온 좌표에 한해서 nx로 b점프 가능이란 뜻.
				if(nx >=0 && !ch[1][nx] && cur[1] == 0) { //따라서 직전 점프가 0 (앞에서 온 경우에만) b로 점프 가능함
					ch[1][nx] = true;
					Q.add(new int[] {nx, 1});
				}
			}
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