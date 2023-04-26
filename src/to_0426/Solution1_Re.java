package to_0426;
/* 2-4. 해싱으로 다시 풀어보기 
 * */
import java.util.*;
public class Solution1_Re {
	public int solution(int[] nums, int m){
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		map.put(0, 1);
		//하나씩 뽑아서 
		for(int x : nums) {
			//누적 합 구하되 
			sum+= x; 
			//만약 맵에 현재 sum-m의 값이 존재한다면, 그 값의 빈도수만큼 answer++
			if(map.containsKey(sum-m)) answer += map.get(sum-m);
			//현재의 sum 종류별 빈도수를 다시 맵에 누적 
			map.put(sum,  map.getOrDefault(sum, 0)+1);
		}
		return answer;
	}

	public static void main(String[] args){
		Solution1_Re T = new Solution1_Re();
		System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));	
		System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));	
		System.out.println(T.solution(new int[]{-1, 0, 1}, 0));	
		System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));	
	}
}