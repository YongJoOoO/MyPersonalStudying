package to_0412;
/* 1-1. 사다리 타기 | 자리교환 
 * */
import java.util.*;
class Solution1 {
	public char[] solution(int n, int[][] ladder){
		char[] answer = new char[n];
		
		//우선 기본 answer는 대문자 A ~ 차례로 세팅 초기화
		for(int i=0; i<n; i++) {
			answer[i] = (char)(i+65);
		}
		
		//실질적인 자리 교환 로직
			//1) 사다리 각 가로줄 뽑아옴 
		for(int[] line : ladder) {
				//2) 뽑아온 가로줄 차례로 탐색  
			for(int x: line) {
				char tmp = answer[x];
				answer[x] = answer[x-1];
				answer[x-1] = tmp;
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
	}
}