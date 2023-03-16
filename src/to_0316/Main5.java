package to_0316;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* 6-7. 좌표 정렬
[입력]
첫째 줄에 좌표의 개수인 N(3<=N<=100,000)이 주어집니다.
두 번째 줄부터 N개의 좌표가 x, y 순으로 주어집니다. x, y값은 양수만 입력됩니다.
[출력]
N개의 좌표를 정렬하여 출력하세요.*/

class Point implements Comparable<Point>{
	public int x, y;
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	//재정의 - 이 객체를 어떤 조건으로 정렬해줄 것인지 재정의 (현재는 오름차순 정렬)
	@Override
	public int compareTo(Point obj) {
		//만약 x가 같을 경우, y 기준 정렬하고 
		if(this.x == obj.x) {
			return this.y - obj.y; //작은거-큰거
		}else {
			//아니면 x 기준 정렬한다. 
			return this.x - obj.x; //작은거-큰거
		}
	}
}
class Main5 {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Point> arr = new ArrayList<>();
		for(int i =0; i<n; i++) {
			int x = kb.nextInt();
			int y = kb.nextInt();
			arr.add(new Point(x, y)); //담고
		}
		//객체 기준 정렬
		Collections.sort(arr);
		//출력
		for(Point obj : arr) System.out.println(obj.x + " " + obj.y);
	}
	
}