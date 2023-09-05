package to_0905_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/*2458번. 키 순서 - 플로이드 문풀 */
public class Main {
	
	
	//실행 메인
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean[][] chk = new boolean[n][n];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			chk[a][b] = true;
		}
		
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(chk[i][k] && chk[k][j]) {
						chk[i][j] = true;
					}
				}
			}
		}
		
		int cnt[] = new int[n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(chk[i][j]  || chk[j][i]) {
					cnt[i]++;//연결점으로서 처리 
				}
			}
		}
		
		int answer = 0;
		for(int x : cnt) {
			if(x == n-1) answer++;
		}
		System.out.println(answer);
	}

}
