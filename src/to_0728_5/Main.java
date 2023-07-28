package to_0728_5;

import java.util.Scanner;

//최대점수 구하기 (냅색 알고리즘) 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();//문제 개수
		int M = kb.nextInt();//제한 시간 
		
		int[][] arr= new int[N][2];
		
		for(int i=0; i<N; i++) {
			arr[i][0] = kb.nextInt();//얘는 점수 
			arr[i][1] = kb.nextInt(); //얘는 걸리는 시간 
		}
		//1~M분 까지 정의해둔 다음에 i분에 얻을 수 있는 최대 점수 저장할 거임 
		int[] D = new int[M+1];
		//그런데 한 문항당 1번씩만 사용하므로, 문제 조합의 중복 없도록 거꾸로 담음
		
		for(int i=0; i<N; i++) {
			//문제 하나씩 찍어가면서 \
			int mS = arr[i][0];//이 문제 풀때 얻는 점수 
			int mT = arr[i][1];//이 문제 풀때 걸리는 시간 
			
			for(int j= M; j> mT; j--) { //시간 역순으로 
				if(D[j - mT] !=  0) { //조합될 값 존재할 경우에만 갱신
					D[j] = Math.max(D[j], D[j-mT] + mS);//기존값보다 
				}
			}
			//가장 마지막에 해당 답도 세팅 
			D[mT] = Math.max(D[mT], mS);
		}
		
		for(int x : D) System.out.print(x + " ");
	}
}