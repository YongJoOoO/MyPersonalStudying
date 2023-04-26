package to_0426;
/* 2-5. 회장선거 문제풀이 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution2 {
	public String solution(String[] votes, int k){
		String answer = " ";
		String s = " ";

		HashMap<String, Integer> map = new HashMap<>();
		//1) 회장선거 나가는 애 먼저 구해놓고
		for(String x : votes) {
			String[] tmp = x.split(" ");
			map.put(tmp[1], map.getOrDefault(tmp[1], 0)+1);
		}
		
		for(String key : map.keySet()) {
			if(map.get(key) >= k) {
				s += key+" ";
			}
		}
		
		//2) 회장선거 나가는 애를 뽑은 애들 중 가장 많은 선물 받는 애 알파벳 순으로 뽑기
		HashMap<String, Integer> out = new HashMap<>();
		
		for(String x : votes) {
			String[] tmp = x.split(" ");
			if(s.contains(tmp[1])) {
				out.put(tmp[0], out.getOrDefault(tmp[0], 0)+1);
			}
		}
		int max = Integer.MIN_VALUE;
		for(String key : out.keySet()) {
			if(out.get(key) > max) {
				max= out.get(key);			
			}
		}
		ArrayList<String> arr = new ArrayList<>();
		//3) 많이 선물 받은애 까지는 구했는데.
		for(String key : out.keySet()) {
			if(out.get(key) == max) {
				arr.add(key);
			}
		}
		//4) 알파벳 순으로 String 정렬 후 
		Collections.sort(arr);
		//첫 번쨰 값을 answer 에 담기 
		answer = arr.get(0);

		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args){
		Solution2 T = new Solution2();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}