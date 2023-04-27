package to_0427;
/*2-5. 회장선거 */
import java.util.*;
class Solution1 {
	
	//솔루션 함수 
	public String solution(String[] votes, int k){
		String answer = " ";
		//투표 정보 <사람 -> (뽑은 애들) > 형태
		HashMap<String, HashSet<String>> voteHash = new HashMap<>();
		//후보자, 빈도수
		HashMap<String, Integer> candidate = new HashMap<>();
		//선물받는 애 = 후보자로 선발된 애들을 가장 많이 뽑은 사람의 빈도수 
		HashMap<String, Integer> present = new HashMap<>();
		
		for(String x : votes) {
			String a = x.split(" ")[0]; //공백 기준 앞 문자 - 뽑은 이
 			String b = x.split(" ")[1]; //공백 기준 뒷 글자 - 대상 
 			//담기- 뽑은 사람 기준으로 -> 자리 생성해두고 
 			voteHash.putIfAbsent(a, new HashSet<String>());
 			voteHash.get(a).add(b); //a 기준으로 대상 b를 담는다
 			//후보자 누적 
 			candidate.put(b, candidate.getOrDefault(b, 0)+1);
		}
		
		int max = Integer.MIN_VALUE;
		//각각의 뽑은이 하나씩 뽑아와서 
		for(String a : voteHash.keySet()) {
			int cnt = 0;
			//뽑은이 a가 뽑은 대상 b들을 차례로 들고와서
			for(String b : voteHash.get(a)) {
				//b가 후보자인 경우,  카운팅 
				if(candidate.get(b) >= k) cnt++;
			}
			//선물받는 이 a기준에 받는 cnt담음 
			present.put(a, cnt);
			//기존 max와 cnt비교 후 더 큰값을 max로 세팅
			max = Math.max(max, cnt);
		}
		
		//알파벳 순 출력
		ArrayList<String> tmp = new ArrayList<>();
		for(String name : present.keySet()) {
			if(present.get(name) == max) tmp.add(name);
		}
		
		//사전 순으로 비교하여 sort 정렬한다. 
		tmp.sort((a,b) -> a.compareTo(b));
		answer = tmp.get(0);

		return answer;
	}
	//실행 메인 
	public static void main(String[] args){
		Solution1 T = new Solution1();
		System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
		System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
		System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
	}
}