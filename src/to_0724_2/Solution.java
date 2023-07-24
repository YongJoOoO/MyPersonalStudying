package to_0724_2;
import java.util.*;
class Solution {
	public int solution(int[] nums){
		int answer = 0;
		//정렬
		Arrays.sort(nums);
		
		int L = 0, R=nums.length -1;
		while(L<=R) {
			if(nums[L] + nums[R] <= 5) {
				answer++;
				L++;
				R--;
			}else if(nums[L]+nums[R] > 5) {
				answer++;
				R--;
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
		System.out.println(T.solution(new int[]{2, 3, 4, 5}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
	}
}