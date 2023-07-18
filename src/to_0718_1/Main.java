package to_0718_1;

import java.util.Scanner;

//신기한 소수 
public class Main {
	static int N;//자릿수 == 깊이 
	static boolean visited[];//방문 체크용 배열 
	
	//소수 판별용 함수 
	static boolean isSosu(int a) {
		for(int i=2; i<=a/2; i++) {
			if(a % i == 0) {
				return false; 
			}
		}	
		return true;
	}
	
	//dfs
	static void dfs(int num, int lv) {
		if(lv == N) {//주어진 자릿수 까지 뻗은 경우 
			//완성된 4자리를 다시 소수 판별 후 
			if(isSosu(num)) {
				System.out.println(num);//출력 
			}
			return;//아니면 그냥 반환 
		}
		for(int i=1; i<10; i++) {
			if(i % 2==0)  {//짝수는 그냥 건너뛰고 
				continue;
			}
			if((isSosu(num * 10 + i))) { //추가한 숫자를 현재 숫자 뒤에 이어붙여서 소수 판별 
				dfs(num * 10 + i, lv+1); //더 깊이 탐색 
			}
		}
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		
		dfs(2, 1);//2로 시작하는 값 - 1의 자리
		dfs(3, 1);
		dfs(5, 1);
		dfs(7, 1);
	}
}