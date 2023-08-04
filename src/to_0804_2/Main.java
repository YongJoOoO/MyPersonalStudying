package to_0804_2;

import java.util.Scanner;

//투포인터 - 2018번. 수들의 합 5
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		//st~ed까지의 연속된 자연수 합 구하고, 그 합이 N이 될 떄 cnt++
		int st =1, ed =1;
		int cnt = 1;//15 자기자신일 경우 1개 미리 세팅 
		int sum = 1;
		
		while(ed != N) {
			if(sum == N) {
				cnt++;
				ed++;
				sum += ed;
			}else if(sum < N) { //작으면 
				ed++;
				sum+= ed;
			}else if(sum > N) { //크면
				sum-=st; //기존 st 빼고
				st++;//st++ 처리 
			}
		}
		
		System.out.println(cnt);
	}
}