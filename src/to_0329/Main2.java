package to_0329;

import java.util.ArrayList;
import java.util.Scanner;
/* 8-14. 피자 배달 거리 (DFS) */
class Point{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main2 {
	static int n, m, len, answer= Integer.MAX_VALUE;
	static int[] combi;
	static ArrayList<Point> pz, hs;
	//DFS - 조합의 경우의 수 
	public void DFS(int L, int s) {//start 번호
		if(L == m) { //여기는 다 뽑은 거임 ex) 0, 2, 3, 4 뽑았다 치자.
			//최소 거리 구해야 함
			int sum= 0;
			for(Point h : hs) { //각 집 하나 꺼내서 
				// 각 집의 좌표 모두 꺼내서 살아남은 피자집과의 거리 구하고  최소값 담아두기 
				int dis = Integer.MAX_VALUE;
				for(int i : combi) { //뽑인 m개의 피자집들 인덱스 번호 갖고 있음
					dis = Math.min(dis, Math.abs(h.x-pz.get(i).x) + Math.abs(h.y-pz.get(i).y));
				}
				//현재 꺼낸 house와 살아남은 각 피자집 거리 중 최소값이 dis에 저장되었으니
				//이제 도시 배달 거리 구하려면 sum에 누적한다.
				sum += dis;
			}
			//도시의 피자배달 거리가 최소가 되는 M개의 피자집 선택해야 하니까
			answer = Math.min(answer, sum);	
		}else {
			//전체 len개의 피자집 중에서 m개를 고를 거임|여기서 m개 뽑았으면 
			for(int i=s; i<len; i++) {
				combi[L] = i; //인덱스 번호 담아주고 
				DFS(L+1, i+1);
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb =new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();
		pz = new ArrayList<>();
		hs = new ArrayList<>();
		
		//입력 받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int tmp = kb.nextInt();
				if(tmp==1) hs.add(new Point(i,j));
				else if(tmp ==2) pz.add(new Point(i, j));
			}
		}
		
		//1~피자집 중에서 m개 뽑아야 함
		len = pz.size();
		combi = new int[m];
		
		//호출
		T.DFS(0, 0); //0부터 도는 이유는 인덱스 번호 때문ㅇ
		System.out.println(answer);
	}
}