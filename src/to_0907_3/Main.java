package to_0907_3;

import java.util.*;
import java.util.Scanner;

/*11399번. ATM - 그리디 문풀 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int N = kb.nextInt();
		int[] arr = new int[N];
		int[] dy = new int[N];//각 i시간에 기다림+ 인출에 걸린 시간 
		
		for(int i=0; i<N; i++) {
			arr[i] = kb.nextInt();
		}
		
		Arrays.sort(arr);//자동 오름차순 정렬 
		
		dy[0] = arr[0];
		
		for(int i=1; i<N; i++) {
			dy[i] = dy[i-1] + arr[i];
		}
		int sum= 0;
		for(int i=0; i<N; i++) {
			sum += dy[i];
		}
		System.out.println(sum);
		
	}
}