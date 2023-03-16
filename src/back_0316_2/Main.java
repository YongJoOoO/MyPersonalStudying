package back_0316_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
/* 10814번. 나이순 정렬
 * 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 
 * 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
*/
class Person implements Comparable<Person>{
	int age;
	String name;
	
	Person(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	@Override
	public int compareTo(Person obj) {
		//age 기준 오름차순 정렬
		return this.age-obj.age;
	}
}
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		int n = kb.nextInt();
		ArrayList<Person> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int a = kb.nextInt();
			String name = kb.next();
			arr.add(new Person(a, name));
		}
		
		//정렬
		Collections.sort(arr);
		
		for(Person obj : arr) {
			System.out.println(obj.age+" " +obj.name);
		}
	}
}