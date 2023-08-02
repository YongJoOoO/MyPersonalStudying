package to_0802_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//1446번. 지름길 
class Doro{
	int s;
	int e;
	int j;//지름길
	Doro(int s, int e, int j){
		this.s = s;
		this.e= e;
		this.j = j;
	}
}
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();//도로 개수 
		int M = kb.nextInt(); //목표 길이
		
		int[] dy = new int[M+1];
		ArrayList<Doro> arr = new ArrayList<>();
		
		//입력받기 
		for(int i=0; i<N; i++) {
			int s = kb.nextInt();
			int e = kb.nextInt();
			int j = kb.nextInt();
			arr.add(new Doro(s, e, j));
		}
		
		Arrays.fill(dy, Integer.MAX_VALUE);
		
		for(int i=0; i<10; i++) {
			dy[i] = i * 10;
		}
		
		//채우기
		for(int i=0; i<N; i++) {
			int s = arr.get(i).s;
			int e = arr.get(i).e;
			int j = arr.get(i).j;
			
			dy[e%10] = Math.min(dy[(e-10) % 10] + 10, dy[(e-s) % 10] + j) ;
		}
		
		
	}

}
