package to_0911_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		
		int[] arr = new int[N+1];
		int[] dy1 = new int[N+1];//연속 오름차 길이 
		int[] dy2 = new int[N+1];//연속 내림차 길이 
		
		for(int i=1; i<=N; i++) arr[i] = kb.nextInt();
		
		//시작값은 초기화 해둠 
		dy1[1] = arr[1];
		
		int tmp = arr[1];
		
		for(int j=2; j<=N; j++) { //오름차순 연속 길이 
			if(tmp > arr[j]) {
				dy1[j] = 1;
				tmp = arr[j];
				continue;
			}
			tmp = arr[j];
			dy1[j] = dy1[j-1] + 1;
		}
		
		
		tmp = arr[1];
		for(int i=2; i<=N; i++) {//내림차순 연속 길이 
			if(tmp < arr[i]) {//되려 커진다면 
				dy2[i] = 1;//1로 세팅하고 
				tmp = arr[i];
				continue;
			}
			tmp = arr[i];
			dy2[i] = dy2[i-1] + 1;
		}
		
		int max1 = 0, max2 = 0;//각각 max 구해서 
		for(int i=1; i<=N; i++) {
			max1 = Math.max(max1, dy1[i]);
			max2 = Math.max(max2, dy2[i]);
		}
		
		//max1 vs max2 중에 더 큰 값으로 출력 
		int answer = Math.max(max1, max2);
		
		System.out.println(answer);
		
	}
}