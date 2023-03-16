package back_0316_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 백준 11651번. 좌표 정렬 하기 2
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, 
y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.*/

class Point implements Comparable<Point>{
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Point obj) {
		if(this.y > obj.y) return 1;
		else if(this.y == obj.y && this.x > obj.x) return 1;
		return -1;
	}
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for(int i =0; i<n; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr.add(new Point(x, y));
		}
		
		Collections.sort(arr);
		
		for(Point obj : arr) {
			System.out.println(obj.x + " " + obj.y);
		}
	}
	
}