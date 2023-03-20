package to_0320;
/* 7-2. 재귀함수를 이용한 이진수 출력
 * */
public class Main2 {
	//재귀함수
	public void DFS(int n) {
		if(n == 0) return;
		else {
			DFS(n/2); //2로 나눈 몫을 인수로 계속 호출
			System.out.print(n%2 + " "); //그 나머지를 역순 출력
		}
	}
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		T.DFS(11);
	}
}