package to_0801_5;

import java.util.Scanner;

//1965번. 상자 넣기 
public class Main {
	
	//약간 최대증가부분수열 길이 구하는 느낌과 같다. 친구 결혼식
	//dy[i] 의 정의 : i를 마지막으로 선택했을 때의 최대 길이 정도
	//반드시 큰 상자 안에 작은 상자를 담을 수 있다는 것 주의 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr= new int[n];
		
		for(int i=0; i<n; i++) arr[i] = kb.nextInt();
		
		int[] dy = new int[n];
		
		dy[0]= 1;
		int answer= dy[0];
		for(int i=1; i<n; i++) {
			int max=0;
			for(int j=i; j>=0; j--) {
				if(arr[i] > arr[j] && max < dy[j]) {
					max = dy[j];
				}
			}
			dy[i] = Math.max(dy[i], max+1);//크기 1 추가하니까 
			answer = Math.max(answer, dy[i]);
		}
		System.out.println(answer);
	}
}