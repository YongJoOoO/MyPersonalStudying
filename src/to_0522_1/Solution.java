package to_0522_1;

import java.util.ArrayList;
/* 섹션 4-1. 이진수 정렬 
 * */
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

class NumCnt implements Comparable<NumCnt>{
	int num;
	int cnt;
	NumCnt(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(NumCnt o) {
		// TODO Auto-generated method stub
		if(this.cnt == o.cnt) { //만약 카운팅이 같으면 
			//숫자 오름차순 (작은->큰)
			return this.num - o.num;
		}
		//기본적으로 cnt기준 오름차순 정렬
		return this.cnt - o.cnt;
	}
}

class Solution {
	//솔루션 함수 
	public int[] solution(int[] nums){
		//여기에 1의개수 오름차순 정렬해서 (10진수) 담아 반환 
		int[] answer = new int[nums.length];
		
		ArrayList<NumCnt> list = new ArrayList<>();
		
		String[] tmp = new String[nums.length];
		int[] OneCnt = new int[nums.length];
		
		for(int i = 0; i<nums.length; i++) {
			tmp[i] = Integer.toBinaryString(nums[i]);
			for(char x : tmp[i].toCharArray()) {
				if(x == '1') {
					OneCnt[i]++;
				}
			}
			//list에 담기 
			list.add(new NumCnt(Integer.parseInt(tmp[i]), OneCnt[i]));
		}
		
		//정해둔 기준으로 정렬시킬 것 
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			answer[i] = Integer.parseInt(Integer.toString(list.get(i).num), 2);
		}

		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
		System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
	}
	
}