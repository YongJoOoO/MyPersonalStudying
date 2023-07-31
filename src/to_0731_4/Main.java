package to_0731_4;

import java.util.Scanner;

//최대 점수 구하기 
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();//문제 개수
		int m = kb.nextInt();//시간 제한 
		int[] dy = new int[m+1];//제한 시간i 분 안에 얻을 수 있는 최대 점수 
		
		dy[0] = 0;
		for(int i=1; i<n; i++) {
			int sc = kb.nextInt();//현재 점수
			int t = kb.nextInt();//현재 문제 푸는데 걸리는 시간 
			for(int j=m; j>=t; j--) {//현 문제의 시간까지 역순 돌면서 
				dy[j] = Math.max(dy[j], dy[j-t] + sc);//점수 
			}
		}
		System.out.println(dy[m]);//가장 마지막 값 
	}
}