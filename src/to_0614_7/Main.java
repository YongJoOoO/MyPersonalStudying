package to_0614_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*11399번. ATM -- 그리디 */
class Person implements Comparable<Person>{
	int num;//사람 번호 
	int time; //인출 시간 정보 
	
	Person(int num, int time){
		this.num = num;
		this.time = time;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub\\\\
		//만약 인출 시간 동일한 경우, 번호 앞순 우선 정렬 
		if(this.time == o.time) return this.num - o.num;//

		return this.time - o.time;//시간 빠른 사람 우선 정렬 기본 
	}
}
public class Main {
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Person> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			int tmp = kb.nextInt();
			arr.add(new Person(i, tmp));
		}
		
		//정렬 시키기 
		Collections.sort(arr);
		//각 사람별 대기 및 인출시간 저장할 건데 
		int[] sum = new int[n];
		sum[0] = arr.get(0).time;
		
		for(int i=1; i<n; i++) {
			sum[i] = sum[i-1] + arr.get(i).time;
		}
		int answer = 0;
		
		//최종 답은 그 대기시간의 종합 
		for(int i=0; i<n; i++) {
			answer += sum[i];
		}
		
		System.out.println(answer);
	}
}