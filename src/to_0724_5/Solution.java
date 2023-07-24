package to_0724_5;
import java.util.*;
class Solution {
	public int solution(int[] plantTime, int[] growTime){
		int answer = 0;
		int n = plantTime.length;
		int[][] flower = new int[n][2];
		int T = 0;
		for(int i=0; i<n; i++) {
			flower[i][0] = T;
			flower[i][1] =  + plantTime[i] + growTime[i]; //종료일 	
			T = i + plantTime[i];
			answer = Math.max(answer, flower[i][1]);
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