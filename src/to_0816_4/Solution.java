package to_0816_4;
import java.util.*;
//타일점프 RE
class Solution {
	//solution
	public int solution(int[] nums){
		int n = nums.length;
		boolean[] ch = new boolean[n];//방문 체크
		Queue<Integer> Q = new LinkedList<>();
		//시작점 처리
		Q.add(0);
		ch[0] = true;
		int lv = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			//현 레벨에서 큐에 존재하는 모든 좌표 순회할 거임 
			for(int i=0; i<len; i++) {
				int x = Q.poll();//현재 정점
				for(int j=1; j<=nums[x]; j++) {
					int nx = x + j;//다음 정점
					if(nx == n-1) return lv+1;
					
					if(nx < n && !ch[nx]) {
						ch[nx] = true;
						Q.add(nx);
					}
				}
			}
			lv++;
		}
		
		return -1;
	}
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
		System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
		System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
	}
}