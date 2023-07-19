package to_0719_1;
//침몰하는 타이타닉
import java.util.*;
class Solution {
	
	//솔루션 함수 
	public int solution(int[] nums, int m){//N명, Mkg 이하 
		int answer = 0;
		//데이터 정렬시킴
		Arrays.sort(nums);
		int L = 0;
		int R = nums.length -1;
		
		int sum;
		
		while(L <= R) {
			sum = nums[L] + nums[R];
			if(sum > m ) { // 두 값의 합이 m보다 큰 경우, 그냥 answer++처리 후. R-- | 한개만 담는다 이뜻 
				answer++;
				R--;
			}else if(sum <=m) {//작거나 같으면 둘 다 담을 수 있다는 것이므로 
				answer++;
				L++;
				R--;//두 개 다 처리했다는 뜻으로 움직임 
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