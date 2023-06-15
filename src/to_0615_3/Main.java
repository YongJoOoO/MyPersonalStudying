package to_0615_3;

import java.util.ArrayList;
import java.util.Scanner;

/*씨름선수 - 그리디 */
class Person implements Comparable<Person>{
	int k ;
	int mom; 
	Person(int k, int mom){
		this.k = k;
		this.mom = mom;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return o.k - this.k ;//키 기준 내림차순 정렬 
	}
}

public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		ArrayList<Person> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			arr.add(new Person(a, b));
		}
		
		int answer=  1;
		int pivot = arr.get(0).mom;//기준 값
		
		for(int i=1; i<n; i++) {
			//기준보다 몸 적은 애들은 둘다 뒤쳐지는 애들이므로 탈락
			if(pivot > arr.get(i).mom) continue;
			answer++;
			pivot = arr.get(i).mom;
		}
		
		System.out.println(answer);
	}
}