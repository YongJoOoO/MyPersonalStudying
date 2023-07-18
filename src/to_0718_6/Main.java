package to_0718_6;

import java.util.Arrays;
import java.util.Scanner;

//이분탐색 
public class Main {
	static int N, M;
	static int A[];
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);

		N = kb.nextInt();
		A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = kb.nextInt();
		}
		//대상 데이터들 정렬 
		Arrays.sort(A);
		
		M = kb.nextInt();
		for(int i=0; i<M; i++) {
			boolean find = false;
			int target = kb.nextInt();
			
			//이진 탐색 시작 
			int st = 0;
			int ed = A.length - 1;//범위 끝에 달고
			while(st <= ed) {
				int mid = (st+ed) /2;
				int mVal = A[mid];
				
				if(mVal < target) {
					st = mid + 1;//시작범위를 중앙+1에 두고 오르쪽 탐색 
				}else if(mVal > target) {
					ed = mid-1;//끝범위를 중앙 -1에 두고 왼쪽 탐색 
				}else if(mVal == target) {
					find=true;
					break;
				}
			}
			if(find) {
				System.out.println(1);
			}else {
				System.out.println(0);
			}
		}
	}
}