package to_0524_2;

import java.util.*;
class Solution_Re {
	//평균 - 소수점 버림
	public int getAve(int s, int e, int[] score) {
		int sum = 0;
		for(int i=s; i<=e; i++) {
			sum += score[i];
		}
		
		return (int) Math.floor(sum / (e - s + 1));
				
	}
	
	//솔루션 함수 
	public int solution(int[] score, int k){
		int answer = 0;
		
		int n = score.length;
		
		//오름차순 정렬
		Arrays.sort(score);
		
		for(int i = 0; i<n-k ; i++) {
			//양끝단 차이 10이하인 연속된 세 수 발견 시,
			if(score[i+k-1] - score[i] <= 10) {
				//그 평균이 정답이 됨
				return getAve(i, i+k-1, score);
			}
		}

		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution_Re T = new Solution_Re();
		System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
		System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
		System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
		System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
	}
}