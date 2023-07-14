package to_0714_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*백준 13398번. 연속합 2 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		//초기화
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		//L[] 배열 세팅
		int[] L = new int[N];
		L[0] = A[0];
		int result = L[0];
		for(int i=1; i<N; i++) {
			L[i] = Math.max(A[i], L[i-1]+A[i]);
			//기존 값 vs 직전합+현재값 연속합 중 더 큰 값으로 세팅함
			result = Math.max(result, L[i]);
		}
		
		//R[] 배열 세팅 
		int[] R = new int[N];
		R[N-1] = A[N-1];//맨 오른쪽 끝값으로 초기화
		
		for(int i=N-2; i>=0; i--) {
			R[i]=Math.max(A[i], R[i+1]+ A[i]);
		}
		//이제 i로 전체 순회하면서 각 i를 제거하는 효과 내어 비교한 뒤 더 큰값으로 결과 
		for(int i=1; i<N-1; i++) {
			int tmp = L[i-1] + R[i+1];// 각 i값 제거 한 효과다
			///기존 제거 없이 max였던 result와 비교하여 더 큰 값을 result 에 갱신한다. 
			
			result = Math.max(result, tmp);
		}
		//최종 답 출력 
		System.out.println(result+"\n");//여기에 개행하면 된다.?
	}
}