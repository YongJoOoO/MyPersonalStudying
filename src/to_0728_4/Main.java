package to_0728_4;

import java.util.Scanner;

public class Main {
	static int[] dy;
	//solution 함수 
	static int solution(int[] arr) {
		int answer= 0;
		dy = new int[arr.length];
		dy[0] = 1;
		for(int i=1; i<arr.length; i++) {
			for(int j=i; j>=0; j--) {
				if(arr[j] < arr[i]) {
					dy[i] = Math.max(dy[i], dy[j]+1);//현재 값보다 더 큰 길이 갖는 dy[j] 발견 시 +1 처리
				}
			}
			answer = Math.max(answer, dy[i]);
		}
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		int[] arr =new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(solution(arr));
	}
}