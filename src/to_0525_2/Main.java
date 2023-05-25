package to_0525_2;

import java.util.ArrayList;
import java.util.Scanner;

//1929번 소수 구하기 
public class Main {
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		ArrayList<Integer> answer= new ArrayList<>();
		
		int s = kb.nextInt();
		int e = kb.nextInt();
		
		for(int i= s; i<=e ;i++) {
			for(int j=2; j<i; j++) {
				if(i % j ==0) continue;
				else {
					answer.add(i);
				}
			}
		}
		
		//답 출력
		for(int x : answer) {
			System.out.println(x);
		}
		
		
	}

}
