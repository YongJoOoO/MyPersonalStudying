 package to_0406;

import java.util.Scanner;

/* 10-6. 최대점수 구하기 (냅색 알고리즘) */
public class Main4 {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] dy = new int[m+1];
		
		for(int i=0; i<n; i++) {
			//각 문제에 ps 점수, pt 시간 담기 
			int ps = kb.nextInt();
			int pt = kb.nextInt();
			for(int j =m; j>=pt; j--) {
				dy[j] = Math.max(dy[j], dy[j-pt]+ps);
			}
		}  
		System.out.println(dy[m]);
	}
}