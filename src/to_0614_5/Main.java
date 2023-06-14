package to_0614_5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*1931번. 회의실 배정 */
public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[][] A = new int[N][2];
		//입력받고
		for(int i=0; i<N; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			A[i][0] = s; //시작
			A[i][1] = e; //종료 
		}
		//정렬
		Arrays.sort(A, new Comparator <int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[1] == o2[1]) {//종료시간 같다면 
					return o1[0] - o2[0];//시작 시간 빠르 순 
				}
				//기본적으로 종료시간 우선 정렬
				return o1[1] - o2[1];
			}
		});
		
		int et = 0;
		int cnt = 0;//카운팅 
		
		for(int i=0; i<N; i++) {
			if(et <= A[i][0]) {
				//현재 종료시간 보다 크거나 같은 시작시간 회의 발견ㅅ ㅣ
				cnt++;
				et = A[i][1];//종료시간을 해당 회의의 종료시간으로 갱신 
			}
		}		
		System.out.println(cnt);
	}
}