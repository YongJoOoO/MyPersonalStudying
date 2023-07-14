package to_0714_8;

import java.util.Scanner;

/*연속합 다시 풀이 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N =kb.nextInt();
		
		int[] A = new int[N];
		//데이터 입력받기 
		for(int i=0; i<N; i++) {
			A[i]= kb.nextInt();
		}
		int result = A[0];//얘로 i포함한 연속합 최댓값 찍을 거임 
		//L[] 데이터 처리 
		int[] L = new int[N];
		L[0]= A[0];
		for(int i=1; i<N; i++) {
			L[i] = Math.max(A[i], L[i-1]+A[i]);
			result = Math.max(result, L[i]);
		}		
		//R[] 데이터 처리 
		int[] R = new int[N];
		R[N-1] = A[N-1]; //오른쪽 끝 데이터 초기화 
		for(int i=N-2; i>=0; i--) {
			R[i]= Math.max(A[i], R[i+1]+A[i]);
		}
		//이제 i로 전체 순회하며 값 찍고, 그 값 제외한 값이 기존 result보다 크면 갱신
		for(int i=1; i<N-1; i++) {
			int tmp = L[i-1] + R[i+1];
			result = Math.max(result, tmp);
		}
		System.out.println(result + "\n"); //개행문자 포함하여 답 출력 
	}
}