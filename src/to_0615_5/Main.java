package to_0615_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*결혼식 문제 */
class Person implements Comparable<Person>{
	int st;
	int ed;
	Person(int st, int ed){
		this.st = st;
		this.ed = ed;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.st - o.st;//시작시간 오름차순 
	}
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		ArrayList<Person> arr = new ArrayList<>();
		
		int n =kb.nextInt();
		for(int i=0; i<n; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			arr.add(new Person(a,b));
		}
		Collections.sort(arr);
		
		int[] cnt = new int[n];
		
		int s = arr.get(0).st;
		int e = arr.get(0).ed;
		
		for(int i=1; i<n; i++) {
			if(s <= arr.get(i).st && arr.get(i).st < e) {
				cnt[i]++;
			}
			s = arr.get(i).st;
			e = arr.get(i).ed;
		}
		
		int max = 0;
		for(int x : cnt) {
			if(x > max) x = max;
		}
		System.out.println(max);
	}

}
