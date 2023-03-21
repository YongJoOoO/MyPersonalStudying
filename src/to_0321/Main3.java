package to_0321;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*7-8. 송아지 찾기 (BFS) 
[입력]
첫 번째 줄에 현수의 위치 S와 송아지의 위치 E가 주어진다. 
직선의 좌표 점은 1부터 10,000까지이다.
[출력]
점프의 최소횟수를 구한다. 답은 1이상이며 반드시 존재합니다.*/
public class Main3 {
	//한 번의 점프 당 좌표 가능
	int[] dis = {1, -1, 5};
	//체크배열(방문여부)
	int[] ch;
	//큐
	Queue<Integer> Q = new LinkedList<>();
	//BFS 함수
	public int BFS(int s, int e) {
		ch=new int[10001]; // 1~10000 찍기 위함
		//들어온 루트 s 방문 처리
		ch[s] = 1;
		Q.offer(s);
		
		int L=0;  //레벨
		while(!Q.isEmpty()) {
			int len = Q.size();
			//각 레벨에 대한 작업
			for(int i=0; i<len; i++) {
				int x = Q.poll();//현재 대상 뽑고
				//목적지 e에 해당하는 원소인지 여기서 체크 후 
				if(x == e) return L;
				//아닌 경우, 다시 현 원소에 대한 3가지 점프 경우의 수(위치 dis)
				for(int j=0; j<3; j++) {
					int nx = x + dis[j];//현 원소에서 가능한 각 좌표 더함
					if(nx>=1 && nx<=10000 && ch[nx] == 0) {
						// 좌표평번 내부의 값이면서, 방문 안한 nx 점에 대하여
						//방문 처리
						ch[nx] = 1;
						Q.offer(nx); 
					}
				}
			}
			//레벨++
			L++;
		}
		return 0;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		Scanner kb= new Scanner(System.in);
		int s = kb.nextInt();
		int e = kb.nextInt();
		//출력
		System.out.println(T.BFS(s, e));
	}
}