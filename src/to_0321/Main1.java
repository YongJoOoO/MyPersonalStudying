package to_0321;
/* 7-6. 부분집합 구하기 DFS */
public class Main1 {
	//집합 원소의 개수  
	static int n;
	
	//각 원소 부분집합 사용 여부 체크 배열
	static int[] ch;
	
	//DFS 함수
	public void DFS(int L) {
		if(L == n+1) { // 단말 노드까지 찍으면 종료 
			String tmp = "";
			//전체 순회하면서 사용 체크된 원소만 String에 이어붙임
			for(int i = 1; i<= n; i++) {
				if(ch[i] == 1) tmp+= (i+ " ");
			}
			//공집합 제외 출력
			if(tmp.length()>0) System.out.println(tmp);
		}else {
			//각 원소에 대해서 재귀 호출
			//왼쪽 (사용O)
			ch[L] = 1; //사용O 체크
			DFS(L+1);
			//오르쪽 (사용X)
			ch[L] = 0; //사용x 체크 
			DFS(L+1);
		}
	}	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		n = 3;
		ch = new int[n+1];
		T.DFS(1);
	}
}