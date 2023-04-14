package to_0414;
/* 1-5. 최대길이 바이토닉 수열 */
import java.util.*;

class Solution3 {
	public int solution(int[] nums){
		int answer = 0;
		int n = nums.length;
		ArrayList<Integer> peaks = new ArrayList<>();
		//봉우리 인덱스값 담기
		//맨끝(양쪾) 부분은 어차피 봉우리 못되므로 탐색 구간에서 제외
		//-> 즉, 0과 n은 제외 
		for(int i=1; i< n-1; i++) {
			//현재의 i지점의 좌우 값이 모두 작으면 현재 i는 봉우리임 
			if(nums[i-1] < nums[i] && nums[i] > nums[i+1]) {
				peaks.add(i);
			}
		}
		
		//각 봉우리 지점별 순회하면서
		for(int x : peaks) {
			int left = x;
			int right = x;
			int cnt = 1; //봉우리 지점 길이 카운팅하고  
			//현 x의 왼쪽 구간 차례로 감소 수열인지 확인 
			while(left-1>=0 && nums[left-1] <nums[left]) {
				left--;
				cnt++;
			}
			//현 x의 오르쪽 구간 차례로 감소 수열인지 확인
			while(right+1 < n && nums[right]> nums[right+1]) {
				right++;
				cnt++;
			}
			answer = Math.max(answer, cnt);//기존 answer보다 더 큰 cnt 나타나면 세팅
		}
		return answer;	
	}
	//실행 메인 
	public static void main(String[] args){
		Solution3 T = new Solution3();
		System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
		System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
		System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
		System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
	}
}