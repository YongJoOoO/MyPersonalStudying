package to_0720_8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Person implements Comparable<Person>{
	String name;
	int time;
	Person(String name, int time){
		this.name = name;
		this.time = time;
	}
	//시간 빠르 순 정렬시켜놓기 
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.time - o.time; //더 작은 시간 앞순 
	}
}
class Solution {
	//시간 얻기 
	public int getTime(String time) {
		int H = Integer.parseInt(time.split(":")[0]);
 		int M = Integer.parseInt(time.split(":")[1]); 
		return 60*H + M;
	}
	//솔루션 함수 
	public String[] solution(String[] reports, String times){
	
		int st = getTime(times.split(" ")[0]);
		int ed = getTime(times.split(" ")[1]);
		
		PriorityQueue<Person> pQ = new PriorityQueue<>();
		
		for(int i=0; i<reports.length; i++) {
			String name = reports[i].split(" ")[0];
			int time = getTime(reports[i].split(" ")[1]);
			pQ.add(new Person(name ,time));
		}
		
		//시간 순서대로 정렬된 Person을 순서대로 답 세팅하면 되는데 
		ArrayList<String> arr = new ArrayList<>();
		for(int i=0; i<reports.length; i++) {
			Person cur = pQ.poll();
			if(cur.time >= st && cur.time <= ed) {
				arr.add(cur.name);
			}
		}
		
		
		String[] answer = new String[arr.size()];
		for(int i=0; i<arr.size(); i++) {
			answer[i] = arr.get(i);
		}
		
		return answer;
	}
	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}