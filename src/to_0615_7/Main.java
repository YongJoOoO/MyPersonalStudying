package to_0615_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*회의실 배정 */
class Room implements Comparable<Room>{
	int st;
	int ed;
	Room(int st, int ed){
		this.st = st;
		this.ed =ed;
	}
	@Override
	public int compareTo(Room o) {
		// TODO Auto-generated method stub
		if(this.ed == o.ed) return this.st - o.st;
		return this.ed - o.ed;
	}
	
}
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Room> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			int a = kb.nextInt();
			int b= kb.nextInt();
			arr.add(new Room(a,b));
		}
		Collections.sort(arr);
		
		int cnt= 1;
		int pivot = arr.get(0).ed;
		
		for(int i=1; i<n; i++) {
			if(pivot <= arr.get(i).st) {
				cnt++;
				pivot = arr.get(i).ed;
			}
		}
		System.out.println(cnt);
	}
}