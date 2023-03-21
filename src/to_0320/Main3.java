package to_0320;
/* 7-3. 팩토리얼
 * */ 
public class Main3 {
	//솔루션 함수
	public int DFS(int n) {
		
		if(n==1) return 1; 
		else return n * DFS(n-1);
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main3 T = new Main3();
		System.out.println(T.DFS(5));
	}
}