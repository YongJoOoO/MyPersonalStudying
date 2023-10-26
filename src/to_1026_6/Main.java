package to_1026_6;

import java.util.Scanner;

/**
 * 13305번. 주유소 - 그리디 문풀 : 가격이 싼 기름을 넣자.
 * @author MYLG
 *
 */
public class Main {

	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		int N = kb.nextInt();
		int[] len = new int[N];
		int[] price = new int[N];
		int min = 1000000000;
		int total = 0;
		
		//거리는 N-1개 있다.
		for(int i=0; i<N -1 ; i++) {
			len[i] = kb.nextInt();//갈 때마다 거리
		}

		for(int i=0; i<N; i++) {
			price[i] = kb.nextInt();///각 도시별 주유 가능 가격 
		}
		for(int i=0; i<N-1; i++) {
			min = Math.min(min, price[i]);
			total += min * len[i];
		}
		
		System.out.println(total);
	}
}