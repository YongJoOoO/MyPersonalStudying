package to_0320;
/* 7-1. 재귀함수 */
public class Main1 {	
	//재귀함수
	public void DFS(int n) {
		//종료 조건
		if(n==0) return;
		else {
			DFS(n-1); //하나씩 줄어들도록 재귀 호출
			System.out.print(n + " ");
		}
	}
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		T.DFS(3);
	}
}