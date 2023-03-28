package to_0328_2;

import java.util.ArrayList;
import java.util.Scanner;

/* 8-14. 피자배달 거리 (삼성 SW 역량평가 기출) DFS */
class Point{
	public int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class Main5 {
	static int n, m, len, answer = Integer.MAX_VALUE;
	static int[] combi;
	//격자판 내의 피자집, 일반집의 좌표 담는 용도 
	static ArrayList<Point> pz, hs;
	
	//DFS - 조합 로직 
	public void DFS(int L, int s) {
		if(L==m) { 
			//조홥 완성됨 - 뽑은 애들 대상으로 sum 구하기 
			int sum = 0;
			//집이 하나 결정되면.
			for(Point h : hs) {
				int dis = Integer.MAX_VALUE;
				for(int i : combi) { //뽑아놓은 피자집 모두 돌면서 거리 측정
					//더 최소 거리 갖는 거 구하기
					dis=Math.min(dis, Math.abs(h.x-pz.get(i).x)+Math.abs(h.y-pz.get(i).y));
				}
				sum += dis;//이게 도시의 각 집-피자 사이 거리 합한 '도시의  피자 배달 거리'
			}
			//기존값보다 sum이 작으면 더 작은값으로 세팅ㄴ
			answer = Math.min(answer, sum);
			
		}else {
			//len개 중에서 m개 뽑는 부분
			for(int i=s; i<len; i++) {
				combi[L] = i;
				DFS(L+1, i+1);
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main5 T = new Main5();
		Scanner kb = new Scanner(System.in);
		// NXN 행렬 
		n = kb.nextInt();
		//도시에서 살릴 M개의 피자집 개수 
		m = kb.nextInt(); 
		pz = new ArrayList<>();
		hs = new ArrayList<>();
		//입력받기
		for(int i= 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				int tmp = kb.nextInt();
				if(tmp==1) hs.add(new Point(i, j));
				else if(tmp==2) pz.add(new Point(i, j));
			}
		}
		//len = 도시에 있는 피자집의 개수.
		len = pz.size();
		//len개의 피자집 중 m개를 뽑아야 함.
		combi = new int[m];
		T.DFS(0, 0);
		System.out.println(answer);	
	}
}