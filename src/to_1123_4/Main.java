package to_1123_4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 13549번. 숨바꼭질 3 - BFS */
class Node{
	int x, time;
	Node(int x, int time){
		this.x =x;
		this.time = time;
	}
}
public class Main {
	static int N, K;
	//여기서 N, K는 0 ~ 100,000 범위에 존재해야 한다.
	static int max_node = 100000;
	static boolean[] visited;

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		K = kb.nextInt();
		
		Queue<Node> Q  = new LinkedList<>();
		visited = new boolean[max_node + 1];
		//시작점 담기 
		Q.offer(new Node(N, 0));
		int min = Integer.MAX_VALUE;//여기에 최소 시간 담아야 하니까 
	
		while(!Q.isEmpty()) {
			Node cur = Q.poll();
			visited[cur.x] = true;
			
			if(cur.x == K) {
				//발견한 건데, 그 중에서 time값이 최소인 걸로 세팅함
				min = Math.min(min, cur.time); //가장 최소 시간으로 담기
			}
			//현재 다음 좌표 찾기 
			if(cur.x * 2 <= max_node && !visited[cur.x * 2]) {
				Q.offer(new Node(cur.x * 2, cur.time));//ㄱ드래돌
			}
			
			if(cur.x + 1 <= max_node && !visited[cur.x + 1]) {
				Q.offer(new Node(cur.x+1, cur.time + 1));
			}
			if(cur.x - 1 >= 0 && !visited[cur.x - 1]) {
				Q.offer(new Node(cur.x - 1, cur.time + 1));
			}
		}
		System.out.println(min);
	}
}