package to_0816_6;
//집으로 가자
import java.util.*;
class Solution {
	
	//solution
	public int solution(int[] pool, int a, int b, int home){
		int[][] ch = new int[2][10001];//체크 배열 
		//웅덩이에 대해서는 사전 체크
		for(int x : pool) {
			ch[0][x] = 1; //앞으로 오든
			ch[1][x] = 1; //뒤로 오든 웅덩이는 미리 체크
		}
		Queue<int[]> Q = new LinkedList<>();
		//시작점 0에 대한 방문 체크
		ch[0][0] = 1;
		ch[1][0] = 1;
		Q.offer(new int[] {0, 0});//시작지점 방문 
		int lv = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();//현재 레벨에서 갈 수 있는 정점 차례로 순회
			for(int i=0; i<len; i++) {
				//현재 정점을 cur[0] : 앞에서 왔다. cur[1] : 뒤에서 왔다.
				int[] cur = Q.poll();
				//1) 앞에서 온 애들에 대하여 처리 
				if(cur[0] == home) return lv;
				
				//a 로 뻗어나갈 때
				int nx = cur[0] + a;//a로 갈 수 있는 다음 지점 
				//다음 정점이 유효하면서 앞으로 이동하는 nx지점이 방문 전이면
				if(nx <= 10001 && ch[0][nx] == 0) {
					ch[0][nx] = 1;//앞으로 nx 지점 가는 방문 체크
					Q.offer(new int[] {nx, 0});//앞으로, nx 간다고 처리 
				}
				
				//b로 뒤로 가는 거 처리 cur[0] - b == 0 즉, 앞에서 온 지점일 경우
				nx = cur[0] - b;
				//뒤로 점프한 값이 0보다 커야 하며, 뒤로 nx간애가 방문 전이고,
				//cur[1] == 0 : 뒤로 점프 2번 연속 불가능하므로 이전 점프가 앞일 때에만 뒤로 점프
				if(nx >= 0 && ch[1][nx] == 0 && cur[1] == 0) { //직전 정점이 cur[1] 즉, 앞 점프 안했을 때에만 뒤 점프 허용
					ch[1][nx] = 1;
					Q.offer(new int[] {nx, 1});
				}
			}
			lv++;//레벨++
		}
		return -1;//없다면 -1리턴 
	}
	//main
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));	
		System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));	
		System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));	
		System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));	
		System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));	
	}
}