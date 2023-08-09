package to_0809_4;
import java.util.*;
//바둑대회 - RE 풀이 
class Solution {
	static int n, answer;
	static int[] ch;
	//DFS
	static void DFS(int lv, int s, int[][] cans) {
		if(lv == n/2) {
			ArrayList<Integer> A = new ArrayList<>();
			ArrayList<Integer> B = new ArrayList<>();
			
			for(int i=0; i<n; i++) {
				if(ch[i] == 1) A.add(i);
				else B.add(i);
			}
			int Asum = 0, Bsum = 0;
			for(int i=0; i<lv; i++) {
				Asum += cans[A.get(i)][0];//0번째가 흰돌
				Bsum += cans[B.get(i)][1];//1번째가 검은돌
			}
			answer = Math.min(answer, Math.abs(Asum - Bsum));
			
		}else {
			for(int i = s; i<n; i++) {
				ch[i]= 1;
				DFS(lv+1, i+1, cans);
				ch[i] = 0;
			}
		}
	}
	
	//솔루션 
	public int solution(int[][] cans){
		answer = 1000000000;
		n = cans.length;
		ch = new int[n];
		DFS(0, 0, cans);
		
		return answer;
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{87, 84}, {66, 78}, {94, 94}, {93, 87}, {72, 92}, {78, 63}}));
		System.out.println(T.solution(new int[][]{{10, 20}, {15, 25}, {35, 23}, {55, 20}}));
		System.out.println(T.solution(new int[][]{{11, 27}, {16, 21}, {35, 21}, {52, 21}, {25, 33},{25, 32}, {37, 59}, {33, 47}}));
	}
}
