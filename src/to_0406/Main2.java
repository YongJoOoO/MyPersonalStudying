package to_0406;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 10-4. 가장 높은 탑 쌓기  */
//벽돌 Brick 객체
class Brick implements Comparable<Brick> {
	public int s, h, w;
	Brick(int s, int h, int w){
		this.s = s;
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Brick o) {
		// TODO Auto-generated method stub
		return o.s - this.s; //면적 내림차순 정렬 
	}
}
public class Main2 {
	static int[] dy;
	
	//솔루션 함수 
	public int solution(ArrayList<Brick> arr) {
		int answer= 0;
		//s 면적 기준 내림차순 정렬
		Collections.sort(arr);
		
		dy[0] = arr.get(0).h; //첫 높이만 담기
		answer = dy[0];
		
		for(int i=1; i<arr.size(); i++) {
			int max_h = 0;//최대 높이
			for(int j = i-1; j>=0 ; j--) {
				if(arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
					max_h = dy[j];
				}
			}
			dy[i] = max_h + arr.get(i).h;//직전 최대 + 현재 i의 높이 더해주고
			answer = Math.max(answer, dy[i]);
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		int n= kb.nextInt();
		ArrayList<Brick> arr = new ArrayList<>();
		dy = new int[n];
		
		for(int i=0; i<n; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			int c = kb.nextInt();
			arr.add(new Brick(a, b, c));
		}	
		System.out.println(T.solution(arr));
	}
}