package to_0524_6;

import java.util.*;
/* 1764번. 듣보잡 
 * */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb= new Scanner(System.in);
		
		int n= kb.nextInt();
		int m =kb.nextInt();
		
		String[] nM = new String[n+m];
		
		for(int i=0; i<n+m; i++) {
			nM[i] = kb.next();
		}
		
		//맵에 중복 없이 누적시킬 것.
		HashMap<String, Integer> map = new HashMap<>();
		for(int i=0; i<nM.length; i++) {
			map.put(nM[i], map.getOrDefault(nM[i], 0)+1);
		}
		//개수
		int answer = 0;
	
		//2이상인거만 누적
		for(String key : map.keySet()) {
			if(map.get(key) >=2) {
				answer++;
			}
		}
		//사전순 출력 해야 함.....
		String[] tmp = new String[answer];
		int t= 0;
		for(String key : map.keySet()) {
			if(map.get(key) >= 2) {
				tmp[t] = key;
				t++;
			}
		}
		
		Arrays.sort(tmp);
		
		//개수 출력 
		System.out.println(answer);
		
		//이름도 출력
		for(String x : tmp) {
			System.out.println(x);
		}
	}
}