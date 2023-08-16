package to_0816_5;
//BFS-타일점프  -> 레벨 탐색 
import java.util.*;
class Solution {
	
	//솔루션 함수 
	public int solution(int[] nums){
		int n = nums.length;
		int[] ch = new int[n];
		Queue<Integer> Q = new LinkedList<>();
		//시작점 처리 
		Q.offer(0);
		ch[0] = 1;
		int lv = 0;//0레벨부터 탐색
		while(!Q.isEmpty()) {
			int len = Q.size();
			//현재 레벨에서 탐색 가능한 모든 노드들이 큐에 담겨 있으므로 큐 내부를 순회
			for(int i=0; i<len; i++) { 
				//현재 레벨에서 방문 가능한 현재 정점
				int x = Q.poll();
				for(int j=1; j<=nums[x]; j++) { //1~nums[x]까지 점프 가능
					//닿을 수 있는 그 다음 정점에 대하여 
					int nx = x + j;//각각 점프
					
					if(nx == n-1) return lv+1;
					if(nx < n && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);//담기 
					}
				}
			}//여기까지 하나의 레벨 탐색한 부분이므로 
			lv++;
		}
		return -1;//갈 수 없다면 -1
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
		System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
	}
}