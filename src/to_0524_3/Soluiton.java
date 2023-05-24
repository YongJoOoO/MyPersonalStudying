package to_0524_3;
//4-2. 수열 찾기 
import java.util.*;
class Solution {
	public int[] solution(int[] nums){
		int[] answer = new int[nums.length / 2];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int x : nums) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//오름차순 정렬시켜놓고 
		Arrays.sort(nums);
		int idx = 0;
		for(int x : nums) {
			//카운팅 0 이면 그냥 지나가고 
			if(map.get(x) == 0) continue;
			//정답 세팅 
			answer[idx] = x;
			idx++;
			//최소값 카운팅-1, 
			map.put(x,  map.get(x)-1);
			//최솟값*2 카운팅 -1
			map.put(x*2, map.get(x*2) - 1);
		}
		
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
		System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
		System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
	}
}
