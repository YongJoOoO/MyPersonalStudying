package to_0424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* LIS 복습 
 * */
public class Main {
	//입출력 함수 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	//dy[i]는 그 앞까지의 값 중에 최대 길이 담을 배열
	static int[] dy;
	//솔루션 함수
	public int solution(int[] arr) {
		int answer= 0;
		dy = new int[arr.length];
		for(int i =0; i<arr.length; i++) {
			dy[i] = 1; //무조건 포함 시킴
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					//i앞부분을 j가 차례로 돌면서 +1 시 더 큰 max 갖는 애로 세팅 
					dy[i] = Math.max(dy[i], dy[j]+1);
				}
			}
		}
		for(int i=0; i<dy.length; i++) {
			answer = Math.max(answer, dy[i]);
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		Main T = new Main();
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] tmp = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(tmp[i]);
		}
		//출력 
		System.out.println(T.solution(arr));
	}

}
