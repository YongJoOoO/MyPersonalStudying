package to_0717_4;

import java.util.Arrays;
import java.util.Scanner;

/*1940번. 주몽의 명령 */
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt(); //재료개수 
		int M = kb.nextInt(); //타겟값 
		
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = kb.nextInt();
		}
		//1) 정렬 시킴 오름차순 
		Arrays.sort(A);
		
		//2) 왼, 오 포인터로 찍으면서 답찾기 
		int cnt = 0;
		int st = 0, ed = N-1;
		int sum = 0;
		while(st<ed) {
			sum = A[st] + A[ed];//두 재료의 합 
			if(sum == M) { //정답 찾으면 
				cnt++;
				st++;
				ed--;
			}else if(sum < M) { //값이 작으면 
				st++;
			}else if(sum > M) { //값이 더 크면 
				ed--;
			}
		}	
		System.out.println(cnt);//출력 
	}
}