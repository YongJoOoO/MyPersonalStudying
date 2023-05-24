package to_0524_7;

import java.util.*;

/*11478번. 서로 다른 부분 문자열의 개수 |답은 맞았는데 백준 채점은 틀림 ㅠ */
public class Main {
	//solution
	public int solution(String n ) {
		int answer = 0;
		
		ArrayList<String> arr = new ArrayList<>();
		
		for(int i=0; i<n.length(); i++) {
			String tmp = "";
			for(int j =i; j<n.length(); j++) {
				tmp += n.charAt(j);
				arr.add(tmp);
				answer++;
			}
		}
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.size(); i++) {
			map.put(arr.get(i), map.getOrDefault(arr.get(i), 0)+1);
		}
		
		int m = 0;
		for(String key : map.keySet()) {
			if(map.get(key) >= 2) {
				m++;
			}
		}
		answer -= m;
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		
		String n = kb.next();
		
		System.out.println(T.solution(n));
	}
}