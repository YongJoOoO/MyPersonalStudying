package to_1123_1;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	//솔루션 함수 
	public int solution(int[] nums){
		int n = nums.length;
		int[] ch = new int[n];
		
		Queue<Integer> Q = new LinkedList<>();
		Q.offer(0);
		ch[0] = 1;
		int L = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			//큐의 사이즈 == 현재 위치에서 갈 수 있는 지점 개수
			for(int i=0; i<len; i++) {
				int x = Q.poll();
				//하나씩 뽑아서 
				// => 그때의 nums[x]의 값 이하까지 오른쪽 점프 가능하므로 
				for(int j=1; j<=nums[x]; j++) {
					int nx = x+ j;
					
					//그 정점이 n-1 상점이 된다면 리턴 
					if(nx == n-1) return L+1;
					//그 정점이 아직 n보다 작고, 방문 전의 좌표라면
					if(nx < n && ch[nx] == 0) {
						ch[nx] = 1;//방문 처리 후 
						Q.offer(nx);//큐에 담기 
					}
				}
			}
			L++; //레벨 탐색 
		}
		return -1;
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