package to_0814_8;
//타일점프 - BFS
import java.util.*;
class Solution {
	public int solution(int[] nums){
		
		int n =nums.length;//상점 위치
		boolean[] ch = new boolean[nums.length];

		Queue<Integer> Q = new LinkedList<>();
		int L = 0; //레벨
		//시작점 처리 
		Q.add(0);
		ch[0] = true;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len; i++) {
				int x = Q.poll(); //새 시작점
				for(int j=1; j<=nums[x]; i++) {
					int nx = x + j; //다음 좌표 
					if(nx == n-1) return L+1;//정답 리턴
					if(nx < n && !ch[nx]) {//아직 방문 전이고 n보다 작은 상태면 
						ch[nx] = true;
						Q.add(nx);//담고 
					}
				}
			}
			L++;//레벨++
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