package to_1123_2;
// 레벨 탐색 다시 
import java.util.*;
class Solution {
	
	//솔루션 함수
	public int solution(int[] nums){
		
		int N = nums.length;
		int[] ch = new int[N];
		
		int L = 0;
		Queue<Integer> Q = new LinkedList<>();
		//시작점 처리 
		Q.offer(0);
		ch[0] = 1;//방문체크
		
		while(!Q.isEmpty()) {
			int len = Q.size();//이 사이즈만큼 
			for(int i=0; i<len; i++) {
				int cur = Q.poll();
				
				for(int j=1; j<=nums[cur]; j++) {
					int nx = cur+j;
					if(nx == N-1) return L+1;
					if(nx < N && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
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