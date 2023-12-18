package to_1206_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 문자열 집합 = 해시맵
 * @author MYLG
 *
 */
public class Main {
	//실행 메인
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		
		Map<String, Integer> map = new HashMap<>();
		
		int N =kb.nextInt();
		int M = kb.nextInt();
		
		for(int i=0; i<N; i++) {
			String str = kb.next();
			map.put(str, 1);
		}
		
		int answer  = 0;
		for(int i=0; i<M; i++) {
			String x = kb.next();
			if(map.containsKey(x)) {
				answer++;
			}
		}
		System.out.println(answer);
	}	
}