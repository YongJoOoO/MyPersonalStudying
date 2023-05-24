package to_0524_2;
// 4-4. 심사위원 
import java.util.*;
class Solution {
	//평균 얻기 
	public int getAve(int[] score, int s, int e) {
		int sum = 0;
		
		for(int i=s; i<=e; i++) {
			sum += score[i];
		}
		//소수점 버리기 
		return (int) Math.floor((sum/(e-s+1)));
	}
	
	//솔루션 함수 
	public int solution(int[] score, int k){
		int n = score.length;
		//오름차순 정렬 (작은->큰)
		Arrays.sort(score);
		//이중 for문 안돌고 한번에 끝내는 방법 
		for(int i=0; i<n-k; i++) {
			//처음부터 발견한 차이 10이하의 연속된 값 발견 시, 
			if(score[i+k-1] - score[i] <= 10) {
				return getAve(score, i, i + k - 1);
			}
		}
		
		return 0;
	}
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
		System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
		System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
		System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
	}
}