package to_1010_1;

import java.util.*;

//2251번. 물통 - DFS & BFS 문풀
class AB{
	int A, B;
	AB(int A, int B){
		this.A = A;
		this.B = B;
	}
}
public class Main {
	static int[] Sender = {0, 0, 1, 1, 2, 2};
	static int[] Receiver = {1, 2, 0, 1, 0, 1};
	static boolean[][] visited;
	static boolean[] answer;
	static int[] now;
	//BFS
	static void BFS() {
		Queue<AB> Q = new LinkedList<>();
		Q.offer(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true;
		
		while(!Q.isEmpty()) {
			AB cur = Q.poll();
			int A = cur.A;
			int B = cur.B;
			int C = now[2] - A - B;
			for(int k=0; k<6; k++) {
				int[] nx = {A,B, C};
				nx[Receiver[k] ] += nx[Sender[k]];
				nx[Sender[k]] = 0;
				if(nx[Receiver[k]] > now[Receiver[k]]) {
					nx[Sender[k]] = nx[Receiver[k]] - now[Receiver[k]];
					nx[Receiver[k]] = now[Receiver[k]];
				}
				if(!visited[nx[0]][nx[1]]) {
					visited[nx[0]][nx[1]] = true;
					Q.offer(new AB(nx[0], nx[1]));
					if(nx[0]==0) answer[nx[2]] = true;
				}
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		//물통
		now = new int[3];
		now[0] = kb.nextInt();
		now[1] = kb.nextInt();
		now[2] = kb.nextInt();
		
		visited= new boolean[201][201];
		answer = new boolean[201];
		
		//BFS 호출	
		BFS();
		
		for(int i=0; i<answer.length; i++) {
			if(answer[i]) {
				System.out.print(i+" ");
			}
		}
	}
}