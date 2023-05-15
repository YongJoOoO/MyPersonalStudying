package to_0504;
/* 3-5. CPU 스케쥴링 문제 풀이 */
import java.util.*;
class Solution1 {
	
	//솔루션 함수 
	public int[] solution(int[][] tasks){
		int n = tasks.length;
		int[] answer = new int[n];
		
		LinkedList<int[]> programs = new LinkedList<>();
		for(int i = 0; i < n; i++){
						//(각 i의 0번쨰 (호출시간), 1번쨰 (작업시간), n번 작업번호 ) 를 ArrayList에 담는다. 
			programs.add(new int[]{tasks[i][0], tasks[i][1], i});
		}
		programs.sort((a, b) -> a[0] - b[0]);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
		int fT = 0, idx = 0;
		while(!programs.isEmpty() || !pq.isEmpty()){
			if(pq.isEmpty()) fT = Math.max(fT, programs.peek()[0]);
			while(!programs.isEmpty() && programs.peek()[0] <= fT){
				int[] x = programs.pollFirst();
				pq.add(new int[]{x[1], x[2]});
			}
			int[] ex = pq.poll();
			fT = fT + ex[0];
			answer[idx++] = ex[1];
		}	
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(new int[][]{{2, 3}, {1, 2}, {8, 2}, {3, 1}, {10, 2}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{5, 2}, {7, 3}, {1, 3}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{1, 2}, {2, 3}, {1, 3}, {3, 3}, {8, 2}, {1, 5}, {2, 2}, {1, 1}})));
		System.out.println(Arrays.toString(T.solution(new int[][]{{999, 1000}, {996, 1000}, {998, 1000}, {999, 7}})));
	}
}