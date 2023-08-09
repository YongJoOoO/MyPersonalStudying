package to_0809_2;
import java.util.ArrayList;
import java.util.Collections;
/*가장 가까운 큰 수 */
class Solution {
	static int answer, target;//최초 숫자 담기 
	static ArrayList<Integer> num;
	static boolean[] visited;//방문용
	static boolean flag;
	static int len; //길이 
	//DFS
	static void DFS(int lv, int number) {
		if(flag == true) return;
		
		if(lv == len) {//길이가 7까지 갔고, 
			if(number > target) {
				answer = number;
				flag = true;
			}
		}else {
			for(int i=0; i<len; i++) {
				if(!visited[i]) {
					visited[i] = true;//방문처리 
					DFS(lv+1, number * 10 + num.get(i));
					visited[i] = false;//복귀할 때 false 주고
				}
			}
		}
	}
	
	//솔루션 
	public int solution(int n){
		answer = 0;
		target = n;//담기 
		num = new ArrayList<>();
		flag = false; 
		
		int m =n;
		while(m >0) {
			int t = m % 10;
			num.add(t);
			m = m / 10;
		}
		//오름차순 정렬 
		Collections.sort(num);
		len = num.size();
		visited = new boolean[len];
		
		DFS(0, 0);
		
		if(flag == false) answer = -1;
		
		return answer;
	}
	//main
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(123));
		System.out.println(T.solution(321));
		System.out.println(T.solution(20573));
		System.out.println(T.solution(27711));
		System.out.println(T.solution(54312));
	}
}