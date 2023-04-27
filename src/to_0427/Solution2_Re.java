package to_0427;
/* 2-6. 문서 도난 다시 풀이 */
import java.util.*;
class Info implements Comparable<Info>{
	public String name;
	public int time;
	
	//생성자
	Info(String name, int time){
		this.name= name;
		this.time=time;
	}
	//비교 연산자 
	@Override
	public int compareTo(Info o) {
		// TODO Auto-generated method stub
		//'시간' 기준 오름차순 정렬 
		//cf. 내림차순은 o.time-this.time; 하면 된다. 
		return this.time -o.time;
	}
}

class Solution2_Re {
	//getTime: 시간 파싱 함수 HH:MM 을 분단위로 변환하는 함수 
	public int getTime(String time) {
		int H = Integer.parseInt(time.split(":")[0]);
		int M = Integer.parseInt(time.split(":")[1]);
		return H*60 + M;//분 단위로 변형
	}
	
	//솔루션 함수 
	public String[] solution(String[] reports, String times){

		ArrayList<Info> tmp = new ArrayList<>();
		for(String x : reports) {
			String a = x.split(" ")[0]; //사람 이름 
			String b = x.split(" ")[1];
			tmp.add(new Info(a, getTime(b)));
		}
		
		//'시간'기준 오름차순 정렬 (compareTo())
		Collections.sort(tmp);
		
		//times 구간도 분 단위로 변환
		int s = getTime(times.split(" ")[0]);
		int e = getTime(times.split(" ")[1]);
		
		//시간 구간 내에 속하는 사람만 뽑기 
		ArrayList<String> res = new ArrayList<>();
		for(Info ob : tmp) {
			if(ob.time >= s && ob.time <=e) {
				res.add(ob.name);
			}
			if(ob.time > e) break; //아 시간 순 정렬 했으니까 e 초과하면 그냥 멈춤
		}
		
		//size를 잡아주고 해야 에러가 안난다.
		String[] answer = new String[res.size()];
		for(int i=0; i<res.size(); i++){
			answer[i] = res.get(i);
		}

		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution2_Re T = new Solution2_Re();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}