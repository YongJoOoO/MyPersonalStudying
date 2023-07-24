package to_0724_1;
import java.util.*;
//침몰하는 타이타닉 
class Solution {
	//솔루션 함수 
	public int solution(int[] nums, int m){
		int answer = 0;
		//정렬
		Arrays.sort(nums);
		
		int L = 0, R = nums.length - 1;
		while(L<=R) {
			if(nums[L]+nums[R] <= m) {
				answer++;
				L++;
				R--;
			}else if(nums[L]+nums[R] > m) {
				answer++;
				R--;//R만 처리했다고 치는 거
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
		System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
		System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
	}
}