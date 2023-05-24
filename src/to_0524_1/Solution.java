package to_0524_1;
import java.util.*;
class Solution {
	//솔루션 함수 
	public int solution(int[] nums, int k){
		int answer = 0;
		int n = nums.length;
		//1) 내림차순 정렬시켜놓고 
		Integer[] tmp = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		Arrays.sort(tmp, Collections.reverseOrder());
		
		//2) 차이 담을 diff 배열
		Integer[] diff = new Integer[n/2];
		
		//3) 기본적으로 철수가 가질 홀수번째 값을 누적해놓고, 그 차이도 함께 diff[]배열에 담기  
		for(int i=0; i<n/2; i++) {
			answer += tmp[i*2+1]; //기본적으로 철수가 가질 값
			//그 차이도 계산
			diff[i] = tmp[i*2] - tmp[i*2+1];// 짝수-홀수 차이를 구한다.
		}
		
		//4) diff도 내림차순 정렬시킴
		Arrays.sort(diff, (a, b)-> b-a);
		//5) k번까지만 앞의 차이 더하면 됨
		for(int i=0; i<k; i++) {
			answer += diff[i];
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
		System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
		System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
		System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
		System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
	}
}