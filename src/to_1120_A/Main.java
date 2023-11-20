package to_1120_A;

import java.util.List;
import java.util.*;

/**
 * 씨름선수 - 그리디
 * @author MYLG
 *
 */
class Person implements Comparable<Person>{
	int h, w;
	Person(int h, int w){
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return o.h - this.h;//키 큰순으로 내림찻누 정렬
	}
}
public class Main {
	static int N;
	static List<Person> arr;
	
	//실행메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int h = kb.nextInt();
			int w = kb.nextInt();
			arr.add(new Person(h, w));
		}
		Collections.sort(arr);
		
		//그리디
		int cnt = 1;//키 1등인 애는 어쨋든 다른 모든 애들보다 적어도 키는 크므로 선발 시킴
		int cutLine = arr.get(0).w;//얘가 기준이 될거고 
		
		for(int i=1; i<N; i++) {
			if(cutLine > arr.get(i).w) continue;
			
			cnt++;
			cutLine = arr.get(i).w;
		}
		
		System.out.println(cnt);
		
	}

}
