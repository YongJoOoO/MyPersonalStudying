package to_0811_2;
import java.util.Stack;
//줄다리기 
class Solution {
	static int answer;
	static int[][] relation; //얘한테 관계 담기 
	static Stack<Integer> st;
	static boolean[] visited;//방문 쳌용
	//DFS
	static void DFS(int lv) {
		if(lv == 7) {
			answer++;
			return;
		}else {
			for(int i=1; i<=7; i++) {
				if(!st.empty() && relation[st.peek()][i] == 1) continue;
				if(!visited[i]) {
					st.push(i);
					visited[i] = true;
					DFS(lv+1);
					visited[i] = false;
					st.pop();
				}
			}	
		}
	}
	//솔루션 함수 
	public int solution(int[][] fight){
		answer = 0;
		relation = new int[8][8];
		
		for(int[] x : fight) {
			relation[x[0]][x[1]] = 1;
			relation[x[1]][x[0]] = 1;
		}
		visited= new boolean[8];
		st = new Stack<>();
		
		DFS(0);
		
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
