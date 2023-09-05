package to_0905_1;

import java.util.*;
import java.util.Scanner;

/*1026번. 보물 - 그리디 
 *  S 가 최솟값이 되려면 A와 B에서 남아있는 배열값들 중 매번 가장 작은 값과 가장 큰값끼리 곱한 것을 더해야 한다.
 *  여기서는 S의 결과만 출력하면 되기 땜누에 B를 재배열하지 말라고는 했지만, 
 *  결과적으로 가장 작은 값과 가장 큰 값이 곱해져서 더해질 수 있도록
 *  A를 오름차순 정렬하고, B를 내림차순 정렬시킨다.
 * */
public class Main {

	//실행 메인 - 그리디 : 현재의 상태에서 욕심껏 고르는 거
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		
		for(int i=0; i<N; i++) A[i] = kb.nextInt();
		for(int i=0; i<N; i++) B[i] = kb.nextInt();
		
		//오름차순 정렬 
		Arrays.sort(A);
		
		//내림차순 정렬 
		Arrays.sort(B, Collections.reverseOrder()); 
		
		int S = 0;//저압용
		for(int i=0; i<N; i++) {
			S += (A[i] * B[i]);
		}
		System.out.println(S);
	}
}