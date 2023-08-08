package to_0808_4;
import java.util.ArrayList;
import java.util.Collections;
//가장 가까운 큰 수 - DFS RE 풀이 
class Solution {
	static int answer, target, m;//m은 자릿수 
	static ArrayList<Integer> nums;//기존 값 자르기 
	static int[] ch;//체크용 배열 
	static boolean flag ; //값 발견 컨트롤 
	
	//DFS
	static void DFS(int lv, int number) {
		if(flag) return; 
		if(lv == m) {
			if(number > target) {
				answer = number;// 리턴할 답
				flag = true;
			}
		}else {
			for(int i=0; i<m; i++) {
				if(ch[i] == 0) {
					ch[i] = 1;//방문처리 
					DFS(lv+1, number * 10 + nums.get(i));
					ch[i] = 0;//복귀
				}
			}
		}
	}
	//solution
	public int solution(int n){
		//초기화
		answer = 0;
		flag = false;
		target = n; //기존 값 
		//기존값을 -> 구분짓기 
		nums = new ArrayList<>();
		int tmp = n;
		
		while(tmp >0) {
			int t = tmp % 10;//나머지
			nums.add(t);
			tmp = tmp/ 10;//나누고 
		}
		
		nums.sort((a, b) -> a-b);
		
		m = nums.size();
		ch = new int[m];
		
		DFS(0, 0);
		
		if(flag == false) return -1;
		
		return answer;
	}
	
	//실행 main
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(123));
		System.out.println(T.solution(321));
		System.out.println(T.solution(20573));
		System.out.println(T.solution(27711));
		System.out.println(T.solution(54312));
	}
}