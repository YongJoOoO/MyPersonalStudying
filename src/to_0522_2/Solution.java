package to_0522_2;
/*4-2. 수열 찾기 */
import java.util.*;
class Solution {
	//솔루션 함수 
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length / 2];
		
		//1)일단 nums 정렬
		Arrays.sort(nums);
		
		HashMap<Integer, Integer> map= new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0)+1); //빈도수별 카운팅 
		}
		
		int i = 0; 
		for(int key : map.keySet()) {
			if(map.get(key) >= 1) {
				//1) 최솟값 담아주고 
				answer[i] = Collections.min(map.keySet());
				//카운팅-1
				map.put(answer[i], map.getOrDefault(answer[i], 0)-1);
				
				//2) 두배값 존재하면 삭제해줌 
				map.put(answer[i] * 2, map.getOrDefault(answer[i] * 2, 0) -1);
				
				i++;
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}