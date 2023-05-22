package to_0522_1;
//4-1. 이진수 정렬 다시 문풀 
import java.util.*;
class Solution_Re { 
	
	//솔루션 함수 
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length];
		int[][] res = new int[nums.length][2];
		for(int i=0; i<nums.length; i++) {
			int cnt = 0;
			int tmp = nums[i];
			while(tmp > 0){
				cnt += (tmp % 2);
				tmp = tmp/2;
			}
			res[i][0] = nums[i];
			res[i][1] = cnt;
		}
		
		Arrays.sort(res, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
		for(int i =0; i<res.length; i++) {
			answer[i] =res[i][0];
		}
		
		return answer;
	}
	 
	//실행 메인 
	public static void main(String[] args){
		Solution_Re T = new Solution_Re();
		System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
		System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
	}
}