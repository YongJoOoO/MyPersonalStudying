package to_0719_3;
import java.util.*;
//전투게임 
class Student implements Comparable<Student>{
	int num;//번호 
	char team;//팀 구분 
	int score;//공격력
	Student(int num, char team, int score){
		this.num = num;
		this.team = team;
		this.score = score;
	}
	@Override
	public int compareTo(Student o) {
		return o.score - this.score;//역순 내림차순 정렬 (큰 -작은)
	}
}
class Solution {
	//솔루션 함수 
	public int[] solution(String[] students){
		int n = students.length;
		int[] answer = new int[n];
		
		ArrayList<Student> arr = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			char a = students[i].split(" ")[0].charAt(0);//첫번쨰 값은 팀으로 
			int b = Integer.parseInt(students[i].split(" ")[1]);
			
			arr.add(new Student(i, a, b));//차례대로 객체 집어넣고 
		}
		//공격력 기준 정렬 
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			//현재 i를 기준값으로 
			int num = arr.get(i).num;
			char t = arr.get(i).team;
			int sc = arr.get(i).score;
			
			for(int j=i; j<arr.size(); j++) { //그 뒷부분 돌면서 점수 쌓고 
				if(t != arr.get(j).team && sc > arr.get(j).score) { //현재보다 공격력 작은 애 발견할 때마다 
					answer[num] += arr.get(j).score;//여기서 누적시키고  
				}
			}
		}
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
		System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
	}
}