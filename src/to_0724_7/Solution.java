package to_0724_7;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Student implements Comparable<Student>{
	int num;
	char team;
	int score;
	Student(int num, char team, int score){
		this.num = num;
		this.team = team;
		this.score = score;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.score - this.score;//점수 큰 순서대로 정렬 
	}
	
}
class Solution {
	//솔루션 함수 
	public int[] solution(String[] students){
		int n = students.length;
		int[] answer = new int[n];
		
		ArrayList<Student> arr = new ArrayList<>();
		for(int i=0; i<n; i++) {
			char team = students[i].split(" ")[0].charAt(0);
			int score = Integer.parseInt(students[i].split(" ")[1]);
			arr.add(new Student(i, team, score));
		}
		Collections.sort(arr);
		
		for(int i=0; i<arr.size(); i++) {
			int num = arr.get(i).num;
			char team = arr.get(i).team;
			int score = arr.get(i).score;
			
			for(int j=i; j<arr.size(); j++) {
				if(team != arr.get(j).team && score > arr.get(j).score) {
					answer[num] += arr.get(j).score;//점수 누적
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