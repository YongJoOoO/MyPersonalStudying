package to_0821_5;
//최소 환승 횟수 
import java.util.*;
class Solution {
	//솔루션 함수 
	public int solution(int[][] routes, int s, int e){
		int answer = 0;
		
		//<역정보, 호선 정보> 로 담는 거임 - 중복없이 Set 사용하여 해당 역을 거치는 호선 정보 담기 
		HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
		
		int n = routes.length;
		for(int i=0; i<n; i++) { //i로 찍기
			//각 호선별 존재하는 역들 모두 x로 탐색함
			for(int x : routes[i]) { //각 i호선에 대한 정보
				graph.putIfAbsent(x, new HashSet<Integer>());//키 존재하지 않으면 생성 후 set 담기 
				graph.get(x).add(i);//생성된 상태에서 방문 역 x로 가는 호선 i를 담기 
			}
		}
		
		Queue<Integer> Q = new LinkedList<>();
		
		//환승횟수 == 레벨
		int[] ch = new int[n];//호선 체크용
		Q.offer(s);//방문 역 담기 
		int lv = 0;
		
		while(!Q.isEmpty()) {
			int len = Q.size();
			for(int i=0; i<len; i++) {//하나의 레벨 안에서 
				int cur = Q.poll();//현재 방문 역
				for(int line : graph.get(cur)) {//현재 방문역을 거치는 호선들 꺼내기 
					if(ch[line] == 1) continue;//방문한 곳은 그냥 거쳐가고
					ch[line]= 1;///방문체크
					for(int stop : routes[line]) {
						if(stop == e) return lv;
						Q.offer(stop);
					}
				}
			}
			lv++;
		}
		
		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
		System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
		System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
		System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
	}
}