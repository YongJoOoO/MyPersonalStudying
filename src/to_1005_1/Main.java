package to_1005_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*13458번. 시험 감독 */
public class Main {
	static int N;
	static int[] A;//각 시험장 N개별 응시자 수 
	static int B, C;//총 감독 1명당 B, 부 감동당 C
	//실행 메인
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		
		//1) B명 마크가능한 총 감독 1명씩 배치 처리 
		long answer = N;
		
		//2) 부감독 철 
		for(int i=0; i<N; i++) {
			A[i] -= B;
			if(A[i] <= 0) continue;
			answer += A[i] / C;//아 횟수는 아아아
			if(A[i] % C != 0) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}