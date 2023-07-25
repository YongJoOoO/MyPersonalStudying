package to_0725_4;

import java.util.Scanner;

/*2073번. 수도배관 공사
 * 기존 용량보다 크면서도, 두 파이프의 조합(중 작은 용량)의 값으로 세팅
 * */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int D = kb.nextInt();
		int P = kb.nextInt();
		int[] dy = new int[D+1];
		
		for(int i=0; i<P; i++) {
			int L = kb.nextInt();//길이값
			int C = kb.nextInt(); //용량값 
			
			for(int j=D; j>=L; j--) {//역으로 돌아야 파이프 중복X(하나씩만 있기때문)
				if(dy[j-L] == 0) continue;//넘어감
				dy[j] = Math.max(dy[j], Math.min(dy[j-L], C));
				//기존 값보다는 크면서, 만들 수 있는 두 파이프의 조합 중 작은 용량값으로 업데이트 
			}
			dy[L] = Math.max(dy[L], C);//기존 값보다 큰 용량으로 세팅 
		}
		System.out.println(dy[D]);//최종 답 출력 
	}
}