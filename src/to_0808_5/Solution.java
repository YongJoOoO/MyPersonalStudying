package to_0808_5;
import java.util.Stack;
/*줄다리기 - DFS */
class Solution {
	static int[] ch;
	static int[][] relation;
	static int answer;
	static Stack<Integer> st;
	
	//dfs
	static void DFS(int lv) {
		if(lv == 7) answer++;
		else {
			for(int i=1; i<8; i++) {
				if(!st.empty() && relation[st.peek()][1] == 1) continue;
				if(ch[i]==0) {
					ch[i]= 1;
					st.push(i);
					DFS(lv+1);
					ch[i]=  0;
					st.pop();
				}
			}
		}
	}
	//solution
	public int solution(int[][] fight){
		answer = 0;
		st = new Stack<>();
		relation = new int[8][8];
		for(int[] x : fight) {
			relation[x[0]][x[1]] = 1;
			relation[x[1]][x[0]] = 1;//서로 체킹
		}
		ch = new int[8];
		DFS(0);
		return answer;
	}
	
	//main
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
		System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
		System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
		System.out.println(T.solution(new int[][]{{1, 7}}));
		System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
	}
}