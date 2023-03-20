package to_0320;
/* 7-4. 피보나치 수열 */
public class Main4 {
	
	//재귀 함수
	public int DFS(int n) {
		int answer = 0;
		
		if(n ==1 ) return 1;
		else if(n ==2) return 1;
		else {
			return DFS(n- 2) + DFS(n-1);
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		int n = 10; 
		for(int i=1; i<=n; i++) System.out.print(T.DFS(i) + " ");
	}
}