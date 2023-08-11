package to_0811_3;
//바둑대회 
import java.util.*;
class Solution {
	static int N, answer;
	static int[] ch;//체크용 배열 
	//DFS
	static void DFS(int lv, int s, int[][] cans) {
		if(lv == N/2) {
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			for(int i=0; i<N; i++) {
				if(ch[i] == 1) A.add(i);
				else B.add(i);//나누고 
			}
			int Asum = 0, Bsum = 0;
			for(int i=0; i<lv; i++) {
				Asum += cans[A.get(i)][0];//흰팀
				Bsum += cans[B.get(i)][1];//흑팀
			}
			answer = Math.min(answer, Math.abs(Asum- Bsum));
		}else {
			for(int i=s; i<N; i++) {
				ch[i] = 1;
				DFS(lv+1, i+1, cans);
				ch[i] = 0;
			}
		}
	}
	
	//solution 
	public int solution(int[][] cans){
		answer = Integer.MAX_VALUE;
		N = cans.length;
		ch = new int[N];
		DFS(0, 0 ,cans);
		return answer;
	}
	//main	
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
		System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
		System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
	}
}
