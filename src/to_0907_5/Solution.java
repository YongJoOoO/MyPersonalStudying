package to_0907_5;
import java.util.Arrays;
class Solution {
	public int solution(int[] nums){
		int answer = 0;
		Arrays.sort(nums);//오름차순 정렬 
		int L = 0, R = nums.length-1;
		
		while(L<=R) {		
			int tmp = nums[L] + nums[R];
			if(tmp > 5) {
				R--;//하나만 처리하고
				answer++;
			}else if(tmp <= 5) {
				answer++;
				L++;
				R--;//둘 다 처리 
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