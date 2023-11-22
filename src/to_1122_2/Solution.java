package to_1122_2;
/**
 * 가장 가까운 큰수- DFS
 */
import java.util.*;
class Solution {
	static int answer = 0;
	static List<Integer> arr;
	static boolean[] visited;
	static boolean flag;
	static int target; 
	
	static void DFS(int L, int number) {
		if(flag) return;
		if(L == arr.size()) {
			//길이 완성이 됐다면
			if(number > target) {
				answer = number;//넘겨주고
				flag = true;
			}
		}else {
			for(int i=0; i<arr.size(); i++) {
				if(!visited[i]) {
					//이구성에 방문 전인경우
					visited[i] = true;
					DFS(L+1, number*10 + arr.get(i));
					visited[i] = false;
				}
			}
		}
	}
	
	public int solution(int n){
		flag = false;
		target = n;
		String tmp = String.valueOf(n);
		visited = new boolean[tmp.length()];
		arr = new ArrayList<>();
		for(int i=0; i<tmp.length(); i++) {
			arr.add(Character.getNumericValue(tmp.charAt(i)));
		}
		Collections.sort(arr);
		
		DFS(0, 0);
		
		if(!flag) {
			return -1;
		}
		
		return answer;
	}
		
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(123));
		System.out.println(T.solution(321));
		System.out.println(T.solution(20573));
		System.out.println(T.solution(27711));
		System.out.println(T.solution(54312));
	}
}