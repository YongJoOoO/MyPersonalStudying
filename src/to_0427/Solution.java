package to_0427;
/* 2-6. 문서 도난 다시 풀기 
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Info1 implements Comparable<Info1>{
	String name; 
	int time;
	
	Info1(String name, int time){
		this.name = name;
		this.time = time;
	}
	@Override
	public int compareTo(Info1 o) {
		// TODO Auto-generated method stub
		//시간 기준 오름차순 정렬
		return this.time - o.time;
	}
}

class Solution {
	//시간 -> 분 단위 변형 함수
	public int getTime(String time) {
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		
		return 60*H + M;
	}
	
	//솔루션 함수 
	public String[] solution(String[] reports, String times){
		//1) 우선 규격 맞춰서 담기 
		ArrayList<Info> arr = new ArrayList<>();
		for(String x : reports) {
			String a = x.split(" ")[0]; //사람
			String b = x.split(" ")[1]; //시간
			
			arr.add(new Info(a, getTime(b)));
		}
		
		//시간 기준 오름차순 정렬
		Collections.sort(arr);
		
		//2) time 구간 이내값만 이름뽑기 
		ArrayList<String> List = new ArrayList<>();
		
		int s= getTime(times.split(" ")[0]);
		int e = getTime(times.split(" ")[1]);
		
		for(Info x : arr) {
			if(x.time >= s && x.time <= e) {
				List.add(x.name);
			}
			if(x.time > e) break; //시간 순 정렬되어 있으므로 넘어가면 그냥 돌지 말고 멈췀
		}
		//3) 답 세팅 
		String[] answer = new String[List.size()];
		for(int i=0; i<List.size(); i++) {
			answer[i]= List.get(i);
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