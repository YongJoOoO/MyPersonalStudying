package to_0728_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]= kb.nextInt();
		}
		int answer = 0;
		//dy배열 선언
		int[] dy = new int[n];
		//하나씩 찍어가면서
		dy[0] = 1;
		for(int i=1; i<n; i++) {
			int cur = arr[i];//현재값			
			for(int j= i; j>=0; j--) {
				if(cur > arr[j]) {
					dy[i] = Math.max(dy[i], dy[j] + 1);//더 큰값으로 세팅 
				}
			}
			answer = Math.max(answer, dy[i]);//가장 큰 dy[i]로 세팅 
		}
		
		System.out.println(answer);
	}
}