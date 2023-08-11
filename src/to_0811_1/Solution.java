package to_0811_1;
import java.util.*;
//가장 가까운 큰 수 
class Solution {
	static int answer, target;
	static int length;
	static boolean visited[];
	static boolean flag;//얘로 값 발견 시 리턴 조건 
	static ArrayList<Integer> num ;
	
	//DFS
	static void DFS(int lv, int number) {
		if(flag) return;
		if(lv == length) {
			if(number > target) {
				answer = number;//갱신해주고
				flag = true;
			}
		}else {
			for(int i=0; i<length; i++) { //0레벨부터 시작해서 차례로 깊이 탐색할 건데 
				if(!visited[i]) {
					//방문 안한 i에 대하여 
					visited[i]= true;//현재의 깊이에서 방문처리 
					DFS(lv+1, number * 10 + num.get(i));//다음 문자 구성 두고 깊이 탐색 
					//복귀 시, 다르깊이에서도 탐색해야하니까 방문 해제
					visited[i] = false;
				}
			}
		}
	}
	
	//솔루션 
	public int solution(int n){
		answer = 0;
		num = new ArrayList<>();
		//n 구성을 쪼개고, 그 구성을 오름차순 정렬하여 깊이 차례로 탐색할 거임
		target = n;//우선 얘가 기준값이 될 거임 
		int tmp = n;//얜 임시
		while(tmp > 0) {
			int t = tmp % 10;
			num.add(t);
			tmp = tmp / 10;
		}
		flag = false;//초기화
		//오름차순 정렬 
		Collections.sort(num);
		length = num.size();//길이 담고
		visited = new boolean[length];
		//DFS 호출 
		DFS(0, 0);//얘가 시작점 
		
		if(flag == false) answer = -1;
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(123));
		System.out.println(T.solution(321));
		System.out.println(T.solution(20573));
		System.out.println(T.solution(27711));
		System.out.println(T.solution(54312));
	}
}