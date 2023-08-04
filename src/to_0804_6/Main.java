package to_0804_6;

import java.util.Arrays;

//프로그래머스 구명보트 - 그리디, 투포인터 
public class Main {
	//솔루션 함수 
	public int solution(int[] people, int limit) {
		int answer = 0;
		
		Arrays.sort(people); //오름차순 무게 정렬시켜놓고 ,
		
		int st = 0, ed = people.length -1;
		
		while(st<= ed) { //주의 (50, 70, 80) 일 경우, 생각
			if(people[st] + people[ed] <= limit) { //둘다 태우는 거니까
				answer++;
				st++;//처리
				ed--;//처리
			}else if(people[st] + people[ed] > limit) {//커버리면
				answer++;//큰 애만 처리 가능
				ed--;//큰 애만 처리시킴
			}
		}
		
		return answer;
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
