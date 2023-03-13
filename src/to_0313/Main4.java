package to_0313;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* 5-8. 응급실
[입력]
첫 줄에 자연수 N(5<=N<=100)과 M(0<=M<N) 주어집니다.
두 번째 줄에 접수한 순서대로 환자의 위험도(50<=위험도<=100)가 주어집니다.
위험도는 값이 높을 수록 더 위험하다는 뜻입니다.
[출력]
M번째 환자의 몇 번째로 진료받는지 출력하세요.
*/

//각 사람 클래스 생성
class Person{
	int id; 
	int priority;
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}
}
// 메인 클래스
public class Main4 {
	//솔루션 함수
	public int solution(int n, int m, int[]arr) {
		int answer= 0;
		Queue<Person> Q = new LinkedList<>();
		//큐 내부 = 대기환자 초기화
		for(int i = 0; i<n; i++) {
			Q.offer(new Person(i, arr[i]));
		}
		//내부 순회
		while(!Q.isEmpty()) {
			//큐에 존재하는 첫 번째 환자tmp 꺼내서 
			Person tmp = Q.poll();
			//큐 내부 돌며
			for(Person x : Q) {
				//꺼낸 tmp보다 우선순위 더 높은 x가 큐에 존재할 경우 
				if(x.priority>tmp.priority) {
					Q.offer(tmp); //일단 꺼낸 애는 뒤에 담기 
					tmp = null;//기존 tmp = null
					break; //탈출
				}
			}
			//탈출했는데도 여전히 tmp 가 null 아니라면
			// -> 자기보다 우선순위 높은 애가 없어서 자기가 진료받는 사람인 거임
			if(tmp!= null) {
				answer++;
				//진료 받은 사람id가 우리가 찾는 사람이면 현재의 answer 리턴
				if(tmp.id == m) return answer;
			}
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4  T = new Main4();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		System.out.println(T.solution(n, m, arr));
	}
}