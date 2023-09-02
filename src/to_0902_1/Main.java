package to_0902_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*백준 14938번. 서강 그라운드 - 플로이드 or 다익스트라 풀이 가능 */
public class Main {
	static int n, m, r;//정점, 기준값, 간선 순
	static int[] item;//각 정점별 얻을 수 있는 아이템 수
	static ArrayList<ArrayList<int[]>> graph;
	
	//솔루션 함수 - 다익스트라 + 솔루션 
	static ArrayList<Integer> solution(int st) {
	
		boolean[] visited = new boolean[n+1];//양방향이라 체크
		int[] distance = new int[n+1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		//가중치 우선 정렬 
		PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		
		//시작점 초기화
		distance[st] = 0;
		pQ.offer(new int[] {st, 0}); //시작 -> 끝 -> 가중치 
		//cur[0]이 e , cur[1] 이 가중치
		while(!pQ.isEmpty()) {
			int[] cur = pQ.poll();
			if(visited[cur[0]]) continue;
			visited[cur[0]] = true;
			
			for(int [] nx : graph.get(cur[0])) {//다음 정점에 대하여
				if(!visited[nx[0]] && distance[nx[0]] > distance[cur[0]] + nx[1]) {
					distance[nx[0]] = distance[cur[0]] + nx[1];
					pQ.offer(new int[] {nx[0], distance[nx[0]]});
				}
			}
		}
		//m이내의 거리에 해당하는 정점들만 보내기 
		ArrayList<Integer> answer = new ArrayList<>();
			
		for(int i=1; i<=n; i++) {
			if(distance[i] > m) continue;
			
			answer.add(i); //m이내의 거리에 존재하는 정점들만 보냄
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		n = kb.nextInt();
		m = kb.nextInt();//얘 걍 기준값
		r = kb.nextInt();
		
		item = new int[n+1];
		graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		//아이템 입력받기 
		for(int i=1; i<=n; i++) {
			item[i] = kb.nextInt();
		}
		
		//그래프 정보 입력
		for(int i=0; i<r; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			//양바향 
			graph.get(a).add(new int[] {b, c});
			graph.get(b).add(new int[] {a, c});
		}
		int max = Integer.MIN_VALUE;
		
		for(int i=1; i<=n; i++) {
			int sum = 0;
			//각각의 1~n까지 차례로 호출하여 시작정점 기준 호출하고 
			for(int x : solution(i)) {//리턴받은 인덱스에 대하여 
				
				sum += item[x];//각 해당하는 정점에 대한 아이템 개수 누적하고 
			}
			
			max = Math.max(max, sum);//그 중 가장 최대 개수를 세팅 
		}
		//정답 출력
		System.out.println(max);	
	}
}