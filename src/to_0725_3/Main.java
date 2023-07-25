package to_0725_3;

import java.util.Scanner;

/*2073번. 수도배관 공사 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner kb= new Scanner(System.in);
		int D = kb.nextInt();
		int P = kb.nextInt();
		int[] dy = new int[D+1];
		 
		for(int i=0; i<P; i++) {
			int L = kb.nextInt();
			int C = kb.nextInt();
			for(int j=D; j>L; j--) { //뒤에서부터 제하는데
				if(dy[j-L] == 0) continue;//아직 값 갱신 안된거니까
				dy[j] = Math.max(dy[j], Math.min(dy[j-L], C));
			}
			dy[L] = Math.max(dy[L], C); //자기 자신. 
		}
		System.out.println(dy[D]);
	}

}
