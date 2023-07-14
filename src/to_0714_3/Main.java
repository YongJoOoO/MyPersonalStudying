package to_0714_3;

import java.io.*;
import java.util.ArrayList;

/*RE 다시 풀기 LCS*/
public class Main {
	//static
	static long[][] DP;
	static char[] A;
	static char[] B;
	static ArrayList<Character> Path;
	
	//getText
	static void getText(int r, int c) {
		if(r==0 || c==0 ) return;
		
		if(A[r-1] == B[c-1]) {
			Path.add(A[r-1]);//문자 기록 
			getText(r-1, c-1);//이동 
		}else {
			if(DP[r-1][c] > DP[r][c-1]) {
				//왼쪽 값이 더크면 
				getText(r-1, c);//거기로 이동
			}else {
				getText(r, c-1);//위로 이동 
			}
		}
	}
	
	//실행 메인 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		
		DP = new long[A.length+1][B.length+1];
		Path = new ArrayList<>();
		
		//담기 
		for(int i=1; i<=A.length; i++) {
			for(int j=1; j<=B.length; j++) {
				if(A[i-1] == B[j-1]) {
					DP[i][j] = DP[i-1][j-1] +1;
				}else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
			}
		}	
		//길이 먼저 출력 
		System.out.println(DP[A.length][B.length]);
		
		//역으로 문자 탐색 시작 
		getText(A.length, B.length);
		
		//역으로 출력 
		for(int i=Path.size()-1; i>=0; i--) {
			System.out.print(Path.get(i));
		}
		System.out.println();
	}
}