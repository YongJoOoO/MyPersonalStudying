package to_0423;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 11053번. 가장 긴 증가하는 부분 수열 
 * */
public class Main {
	//정적 입출력
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//솔루션 함수 
	public int solution(int n, int[] arr) {
		int answer = 0;
		int cnt = 1;
		int[] A = new int[n];
		for(int i=0; i<n; i++) {
			A[i] = 1;
			for(int j = 0; j<i; j++) {
				if(arr[i] > arr[j]) {
					A[i] = Math.max(A[i], A[j]+1);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			answer = Math.max(answer, A[i]);
		}
		return answer;
	}
	
	//메인 
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		Main T = new Main();
		int n = Integer.parseInt(br.readLine());
		String[] tmp = br.readLine().split(" ");
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		
		System.out.println(T.solution(n, arr));
	}

}