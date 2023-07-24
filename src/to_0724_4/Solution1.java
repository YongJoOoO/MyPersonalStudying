package to_0724_4;

import java.util.*;
class Solution1 {
	public int solution(int n, int[] nums){
		int answer = 0;
		int[][] line= new int[n+1][2];
		for(int i=0; i<=n; i++) {
			line[i][0] = Math.max(0, i - nums[i]);  //0보다 큰 애
			line[i][1] = Math.min(n, i + nums[i]); //n보다 작은 애로 갱신 
		}
		int st =0, ed = 0, i=0;
		while(i < line.length) {
			if(line[i][0] <= st) { //선택 가능한 애들 중에서 ed값이 제일 큰 애로 갱신 
				ed = Math.max(ed, line[i][1]);
				i++;
			}
			answer++;//하나 처리 
			if(ed == n) return answer;
			if(st == ed) return -1;
			st = ed;//시작값을 끝값으로 갱신
		}
		return answer;
	}

	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution(8, new int[]{1, 1, 1, 2, 1, 1, 2, 1, 1}));
		System.out.println(T.solution(4, new int[]{1, 2, 2, 0, 0}));		
		System.out.println(T.solution(5, new int[]{2, 0, 0, 0, 0, 2}));
		System.out.println(T.solution(11, new int[]{1, 2, 3, 1, 2, 1, 1, 2, 1, 1, 1, 1}));
	}
}