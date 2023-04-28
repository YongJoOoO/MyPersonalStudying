package to_0428;
import java.util.*;
class Solution1_Re {
	public int solution(int[] nums){
		int answer = 0;
		HashSet<Integer> set = new HashSet<>();
		//1) 중복 제거하기 
		for(int x:nums) set.add(x);
		//2)해쉬셋의 각 값 가져오면서
		for(int x: set) {
			//수열 시작하는 값인지 판별 (얘보다 -1값 존재하면 시작값 x
			if(set.contains(x-1)) continue;
			//만약 시작하는 값이면 
			int cnt=0;
			while(set.contains(x)) {
				cnt++;
				x++;
			}
			answer = Math.max(answer, cnt);
		}

		return answer;
	}

	public static void main(String[] args){
		Solution1_Re T = new Solution1_Re();
		System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
}