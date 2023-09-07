package to_0907_6;
//최소 이동 횟수 : 최소로 이동하고 싶다. = 한 번에 최대한 많이 들고가고 싶다.
import java.util.*;

class Solution {
	//솔루션 함수 
	public int solution(int[] nums){
		int answer = 0;
		int pivot = 5;//기준값이 될 거고
		
		//정렬 시킴 
		Arrays.sort(nums);
		
		int L = 0, R=nums.length-1;//양쪽 끝 지칭시켜놓고 
		int sum;
		while(L <= R) {
			sum = nums[L] + nums[R];
			if(sum > pivot) {
				R--;//큰 것만 담고 이동 
				answer++;
			}else if(sum <= pivot) {
				L++;
				R--;
				answer++;
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
