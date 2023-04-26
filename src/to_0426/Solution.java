package to_0426;
/* 2-5. 회장선거 */
import java.util.*;
class Solution {
	public String solution(String[] votes, int k){
		String answer = " ";
		//투표에 대한 정보를 Hash에 담기 
		HashMap<String, HashSet<String>> voteHash = new HashMap<>();
		//후보자,득표수 
		HashMap<String, Integer> candidate = new HashMap<>();
		//뽑은사람, 수
		HashMap<String, Integer> present = new HashMap<>();
		//각 순회하면서 
		for(String x : votes){
			String a = x.split(" ")[0];
			String b = x.split(" ")[1];
			voteHash.putIfAbsent(a, new HashSet<String>());
			voteHash.get(a).add(b);
			candidate.put(b, candidate.getOrDefault(b, 0) + 1);
		}
		//max 값 갖는 애가 최대로 선물 받은 애가 되므로 구한다
		int max=Integer.MIN_VALUE;
		for(String a : voteHash.keySet()){
			int cnt = 0;
			for(String b : voteHash.get(a)){
				if(candidate.get(b) >= k) cnt++;
			}
			present.put(a, cnt);
			max = Math.max(max, cnt);
		}
		//ArrayList<String>생성 후, max 값 갖는애 add 처리하는데 
		ArrayList<String> tmp = new ArrayList<>();
		for(String name : present.keySet()){
			if(present.get(name) == max) tmp.add(name);
		}
		
		tmp.sort((a, b) -> a.compareTo(b));
		//정렬 후 제일 첫 값은 answer에 담고 리턴
		answer = tmp.get(0);
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}