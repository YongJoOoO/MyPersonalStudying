package to_0630_8;
/*시간 파싱 문제 풀이 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
	//getTime = 시간 분으로 바꿔서 리턴 
	static int getTime(String t) {
		int H = Integer.parseInt(t.split(":")[0]);
		int M = Integer.parseInt(t.split(":")[1]);		
		
		return 60*H + M;
	}
	
	//솔루션 함수 
	public String[] solution(String[] reports, String times){
		
		
		int st = getTime(times.split(" ")[0]);
		int ed = getTime(times.split(" ")[1]);
	
		ArrayList<String > arr = new ArrayList<>();
		
		for(String x : reports) {
			String name = x.split(" ")[0];
			int t = getTime(x.split(" ")[1]);
			
			if(st <= t && t<=ed) {
				arr.add(name);
			}
		}
		
	
		String answer[] = new String[arr.size()];
		
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new String[]{"john 15:23", "daniel 09:30", "tom 07:23", "park 09:59", "luis 08:57"}, "08:33 09:45")));
		System.out.println(Arrays.toString(T.solution(new String[]{"ami 12:56", "daniel 15:00", "bob 19:59", "luis 08:57", "bill 17:35", "tom 07:23", "john 15:23", "park 09:59"}, "15:01 19:59")));
		System.out.println(Arrays.toString(T.solution(new String[]{"cody 14:20", "luis 10:12", "alice 15:40", "tom 15:20", "daniel 14:50"}, "14:20 15:20")));
	}
}