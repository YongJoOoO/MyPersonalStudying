package to_1120_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 7568번. 덩치 - 문풀 
 * @author MYLG
 *
 */
class Person implements Comparable<Person>{
	int num;
	int height, weight;
	Person(int num, int height, int weight){
		this.num = num;
		this.height = height;
		this.weight = weight;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;//몸무게 오름차순(작은 순서대로)
	}
}

public class Main {
	static int N;//전체 사람 수 
	static int[] number;//순서대로 출력할 목적
	static List<Person> arr;
	
	
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		N = kb.nextInt();
		arr = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int a = kb.nextInt();//몸무게
			int b = kb.nextInt();//키
			arr.add(new Person(i, b, a));
		}	
		
		Person pivot = arr.get(0);
		
		for(int i=1; i<N; i++) {
			
		}
		
		
	}

}
