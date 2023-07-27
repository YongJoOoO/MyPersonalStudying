package to_0727_2;

import java.util.Scanner;

/*2073번. 수도배관공사 문제 복습 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int D = kb.nextInt();//목표 길이 
		int P = kb.nextInt();//파이프 종류 
		int[] dy = new int[D+1];
		
		for(int i=0; i<P; i++) {
			int L = kb.nextInt();//길이
			int C = kb.nextInt();//용량 
			
			for(int j=D; j>=L; j++) {
				if(dy[j-L] == 0) continue;
				
				dy[j] = Math.max(dy[j], Math.max(dy[j-L], C));
			}
			dy[L] = Math.max(dy[L], C);
		} 
		System.out.println(dy[D]);
	}

}
