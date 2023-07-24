package to_0724_6;
import java.util.*;
class Solution {
	//솔루션 함수 
	public int solution(int[] plantTime, int[] growTime){
		int answer = 0;
		int n = growTime.length;
		int[][] flower = new int[n][2];
		for(int i=0; i<n; i++) {
			flower[i][0] = plantTime[i];
			flower[i][1] = growTime[i];
		}
		//정렬-성장시간 역순
		Arrays.sort(flower, (a,b) -> (b[1]- a[1]));
		
		//그리디
		int st=0, ed = 0;
		for(int[] x : flower) {
			ed = st + x[0] + x[1];//시작+심기+성장
			answer = Math.max(answer, ed);
			st += x[0];//성장시간 
		}	
		return answer;
	}
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{1, 3, 2}, new int[]{2, 3, 2}));
		System.out.println(T.solution(new int[]{2, 1, 4, 3}, new int[]{2, 5, 3, 1}));
		System.out.println(T.solution(new int[]{1, 1, 1}, new int[]{7, 3, 2}));
		System.out.println(T.solution(new int[]{5, 7, 10, 15, 7, 3, 5}, new int[]{6, 7, 2, 10, 15, 6, 7}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 4, 3, 2, 1, 6}));
	}
}