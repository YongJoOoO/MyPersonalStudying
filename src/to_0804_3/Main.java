package to_0804_3;

import java.util.Arrays;
import java.util.Scanner;

//투포인터 : 주몽 
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		int[] arr= new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
		}
		
		//정렬
		Arrays.sort(arr);
		
		int st= 0, ed=N-1;
		int cnt = 0;
		int sum = 0;
		while(st<ed) {
			sum = arr[st] + arr[ed];
			if(sum == M) {
				cnt++;
				st++;
				ed--;
			}else if(sum <M) {
				st++;
			}else if(sum>M) {
				ed--;
			}
		}		
		System.out.println(cnt);
	}	
}