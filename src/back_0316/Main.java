package back_0316;
/* 11650번. 좌표 정렬하기
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
	public int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	//오름차순 정렬
	@Override
	public int compareTo(Point obj) {
		if(this.x == obj.x) return this.y - obj.y;
		else return this.x - obj.x;
	}
}
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for(int i = 0; i<n; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr.add(new Point(x, y));
		}	
		//정렬
		Collections.sort(arr);
		
		for(Point obj : arr) System.out.println(obj.x + " " + obj.y);
	}
}