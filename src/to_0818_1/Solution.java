package to_0818_1;
/*송아지를 잡자- BFS 레벨 탐색
 * 이 문제는 모든 레벨을 다 탐색해버리면 시간초과가 나버리기 때문에 시간복잡도 줄여야 함
 * [규칙성 발견] : 반복되는 부분은 빼기 
 * 홀수 레벨에서 나타났던 값은 다시 홀수 레벨에서 나타난다.  
 * 따라서 짝수 레벨 위주로 볼 것 */
import java.util.*;
class Solution {
	//솔루션 함수 
	public int solution(int s, int e){
		//ch[0][w] : 짝수 레벨에서 방문하는 지점 체크
		//ch[1][w] : 홀수 레벨에서 방문하는 지점 체크
		int[][] ch = new int[2][200001];
		Queue<Integer> Q = new LinkedList<>();
		//시작점 초기화 - 0레벨에서의 시작점 초기화 - 짝수이므로 0에 s 체크
		int lv = 0;
		ch[0][s]= 1;
		Q.offer(s);
	
		while(!Q.isEmpty()) {
			lv++;//다음 레벨 
			int len = Q.size();
			for(int i = 0; i<len ;i++) {
				int x = Q.poll();
				for(int nx : new int[] {x-1, x+1, x*2}) {
					if(nx >= 0 && nx <= 200000 && ch[lv%2][nx] == 0) {
						ch[lv%2][nx] = 1;
						Q.offer(nx);
					}
				}
			}
			e = e + lv;
			if(e > 200000) return -1;
			if(ch[lv%2][e]==1) return lv;
		}
		return -1;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(1, 11));	
		System.out.println(T.solution(10, 3));	
		System.out.println(T.solution(1, 34567));
		System.out.println(T.solution(5, 6));	
		System.out.println(T.solution(2, 54321));	
	}
}