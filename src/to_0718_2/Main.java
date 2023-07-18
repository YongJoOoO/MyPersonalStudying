package to_0718_2;

import java.util.Scanner;

//신기한 소수 RE
public class Main {
	static int N;
	//소수 판별용 함수 
	static boolean isPrime(int num) {
		for(int i=2; i<=num/2; i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}
	//dfs 함수 
	static void dfs(int num, int lv) {
		if(lv==N) { //만약 끝까지 탐색됐으면 
			if(isPrime(num)) {//완성된 4자릿수가 소수인지 판별 후 
				System.out.println(num);//여기서 출력시키고 
			}
			return;//아니면 그냥 복귀
		}
		for(int i=1; i<=9; i++) {
			if(i%2 ==0) { //붙일 수가 짝수인 경우는 다 제외시킴
				continue;
			}
			if(isPrime(num * 10 + i)) {
				//붙인 수가 소수일 경우,
				dfs(num*10+i, lv+1);//다음 자릿수로 더 깊이 탐색 
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		
		dfs(2,1);
		dfs(3,1);
		dfs(5,1);
		dfs(7,1);
	}
}