package to_24_0106_9;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author MYLG
 *
 */
public class Main {
	static int N;
	static int M;
	static int[] A;
	static int[] arr;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		M = kb.nextInt();
		 // Validate input sizes
        if (N <= 0 || M <= 0) {
           // System.out.println("Array size should be positive.");
            return; // Exit the program
        }

		A = new int[N];
		arr= new int[M];
		
		for(int i=0; i<N; i++) {
			A[i] = kb.nextInt();
		}
		for(int j=0; j<M; j++) {
			arr[j] = kb.nextInt();
		}
		
		Arrays.sort(A);

		for(int i=0; i<M; i++) {
			int target = arr[i];
			
			int st = 0;
			int ed = N-1;
			
			boolean flag = false;
			
			while(st<=ed) {
				int mid = (st + ed) /2;
				
				if(A[mid] < target) {
					st = mid+1;
				}else if(A[mid] > target) {
					ed = mid-1;
				}else {
					flag = true;
					break;
				}
			}
			if(flag) {
				System.out.println("1");
			}else {
				System.out.println("0");
			}
		}
	}
}