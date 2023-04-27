package to_0427;

/* 2-6. 문서 도난
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
class Solution2 {
	public String[] solution(String[] reports, String times){
		String[] answer = {};
		HashMap<String, String> Rmap = new HashMap<>();
		
		//1) 담기 
		for(String x : reports) {
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			Rmap.put(a, b);
		}
		//String 끼리 사전 순 비교하기 : compareTo()
		String start = times.split(" ")[0];
		String end = times.split(" ")[1];
	
		String tmp = "";
		//2) 하나씩 뽑으면서 times 구간 이내 값인지 사전 순 비교 후 이름 뽑기
		for(String key : Rmap.keySet()) {
			//start보다 key의 값이 뒷순서이면서(양수) && end보다는 key의 값이 앞순서일 떄(음수)
			if(Rmap.get(key).compareTo(start) >=0 && Rmap.get(key).compareTo(end) <=0) {	
				tmp += key + " ";
			}
		}
		//value 오름차순 정렬 
		ArrayList<String> List = new ArrayList<>(Rmap.values());
		List.sort(String::compareTo);
		//3) 이제 tmp에 담긴 각 값을 map에서 찾은 뒤 그 value가 더 앞서는 순으로 answer에 담기 
		answer = tmp.split(" ");

		return answer;
	}

	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}