package to_0907_4;
import java.util.*;
class Solution {
	public int solution(int[] nums, int m){
		int answer = 0;
		int N = nums.length;
		Arrays.sort(nums);//오름차순 정렬 
		
		int L =0, R = N-1;
		
		while(L <= R) {
			int tmp = nums[L] + nums[R];
			if(tmp > m) {
				answer++;//개수 R하나만 담고 
				R--;
			}
			else if(tmp <= m) {
				L++;
				R--;
				answer++;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
		System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
		System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
	}
}
