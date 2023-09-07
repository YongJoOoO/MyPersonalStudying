package to_0907_8;
/*그리디 - 전투 게임 문풀 */
import java.util.*;
class Student implements Comparable<Student>{
	int num;//번호
	String team; //소속팀
	int score;//공격력 
	Student(int num, String team, int score){
		this.num = num;
		this.team =team;
		this.score = score;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.score - this.score;//내림차순 - 큰 애 우선 
	}
}

class Solution {
	//솔루션 함수 
	public int[] solution(String[] students){
		int n = students.length;
		int[] answer = new int[n];
		ArrayList<Student> arr =new ArrayList<>();
		for(int i=0; i<n; i++) {
			
			String team = students[i].split(" ")[0];
			int score = Integer.parseInt(students[i].split(" ")[1]);
			
			arr.add(new Student(i, team, score));
		}
		
		Collections.sort(arr);
		
		//현재 학생
		for(int i=0; i<n; i++) {
			Student cur = arr.get(i);
			int sum = 0;
			for(int j=i+1; j<n; j++) { //i뒤부터
				//뒷쪽에 다른 팀이면서 공격력 작은 애 발견 시
				if(!cur.team.equals(arr.get(j).team) && cur.score > arr.get(j).score) {
					sum += arr.get(j).score;
				}
			}
			answer[i] = sum;//여기에 옮겨둠 
		}
		
		return answer;
	}
	//실행 메인
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
	}
}