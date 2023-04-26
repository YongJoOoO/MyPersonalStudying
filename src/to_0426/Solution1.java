package to_0426;
/* 2-4. 음수가 있는 부분수열 문제 풀이 
 * */
import java.util.*;
class Solution1 {
	//솔루션 함수 
	public int solution(int[] nums, int m){
		int answer = 0;
		int[] az = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			az[i] = nums[i];//여기서 한번만 더해주고
			if(az[i] == m) answer++;
			//특정 i찍고 그 앞을 j로 하나씩 거꾸로 가면서 특정 m되면 break
			for(int j= i-1; j>=0; j--) {
				az[i] += nums[j];
				if(az[i] == m) answer++;
			}
		}		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
}