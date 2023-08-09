package to_0809_1;
/*줄다리기 문제 풀이 */
import java.util.*;  
class Solution {
	static int answer;
	static int[][] relation;//관계확인용 
	static boolean[] chk;//방문 체크용 배열 
	static Stack<Integer> stack;//여기에 직전 값 확인용
	
	//DFS
	static void DFS(int lv) {
		if(lv == 7) answer++;
		else {
			for(int i=1; i<=7; i++) {
				//직전 방문한 값과 관련있을 경우 건너뜀 
				if(!stack.empty() && relation[stack.peek()][i] == 1) continue;//건너뜀
				
				if(!chk[i]) { //방문 안한 i에 대하여 
					chk[i] = true;//방문 체크
					stack.push(i);//방문한 애 담기 
					DFS(lv+1);//깊이 탐색 
					chk[i] = false;//복귀할 때 다시 풀어주고
					stack.pop();//다시 빼기 
				}
			}
		}	
	}
	//솔루션 함수 
	public int solution(int[][] fight){
		//초기화 
		answer = 0;
		relation = new int[8][8];
		chk = new boolean[8];
		stack = new Stack<>();
		
		for(int[] x : fight) {
			relation[x[0]][x[1]] = 1;//체크
			relation[x[1]][x[0]] = 1;//양쪽 다 체크 
		}
		
		DFS(0);//0부터 시작 
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
		System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
		System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
		System.out.println(T.solution(new int[][]{{1, 7}}));
		System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
	}
	
}