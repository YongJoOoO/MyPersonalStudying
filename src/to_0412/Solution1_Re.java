package to_0412;
/* 복습 1-1 . 사다리 타기 */
import java.util.*;
class Solution1_Re {
	//n명의 학생, ladder[][] 에 사다리 정보 들어옴 
	public char[] solution(int n, int[][] ladder){
		char[] answer = new char[n];
		//1) 대문자 알파벳으로 초기화
		for(int i=0; i<n; i++) {
			answer[i] = (char) (i+65);
		}
		//2) 실질적인 로직 
		for(int[] line : ladder) {
			//각 라인별 가로줄 뽑아서 
			for(int x : line) {
				//위치 교환
				char tmp = answer[x];
				answer[x] = answer[x-1];
				answer[x-1] = tmp;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Solution1_Re T = new Solution1_Re();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
	}
}