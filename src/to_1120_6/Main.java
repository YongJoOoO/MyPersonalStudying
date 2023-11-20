package to_1120_6;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 씨름선수 - 그리디 문풀
 * @author MYLG
 *
 */
class Person implements Comparable<Person>{
	int h,w;
	Person(int h, int w){
		this.h = h;
		this.w = w;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return o.h- this.h; // 키 오름차순 
	}
}
public class Main {
	static int N;
	static ArrayList<Person> arr;
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		N = kb.nextInt();
		
		arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int a = kb.nextInt();
			int b = kb.nextInt();
			arr.add(new Person(a, b));
		}
		
		int answer = 1;
		//시작값
		Person person = arr.get(0);
		int pivot = arr.get(0).w;//얘가 현재 기준 몸물게임 
		
		for(int i=1; i<N; i++) {
			//기준보다 무게도 적은애는 둘다 뒤쳐지는 애들이므로 넘김
			if(pivot > arr.get(i).w ) continue;
			
			answer++;
			pivot = arr.get(i).w;
		}
		
		System.out.println(answer);
	}

}
