package to_0808_3;
import java.util.ArrayList;
class Solution {
	static int answer, target, m;
	static ArrayList<Integer> nums;
	static int[] ch;//방문체크용 배열 
	static boolean flag;
	
	//dfs
	static void DFS(int lv, int number) {
		if(flag) return;//이제 true 상태에서는 나머지 탐색 X 걍 리턴시킴
		if(lv == m) {//레벨이 깊이 왔으면 
			if(number > target) { //최초로 만들어진 가장 가까운 큰 수 발견 시  
				answer = number;
				flag = true; //true 주고 
			}
		}else {//순열 재귀로 깊이 만드는 부분 
			for(int i=0; i<m; i++) { //길이 차례로 순회하면서 
				if(ch[i] == 0) {
					ch[i] = 1;
					DFS(lv+1, number* 10 + nums.get(i));
					ch[i]= 0;
				}
			}
		}
	}
	
	//solution 
	public int solution(int n){
		//초기화
		answer = 0; 
		flag = false;
		nums = new ArrayList<>();
		target = n;
		int tmp = n;
		
		while(tmp >0) { //분리해서 리스트에 담기 
			int t = tmp % 10;
			nums.add(t);
			tmp = tmp/10;
		}
		nums.sort((a, b) -> a-b); //오름차순 정렬 
		m = nums.size();
		ch = new int[m];
		
		DFS(0,0);//호출
		
		if(flag == false) return -1; //만들 수 없다 -1 리턴
		return answer; //만들어진 숫자 리턴

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