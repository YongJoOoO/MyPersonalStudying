package to_24_0120_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 4195번. 친구 네트워크 - 유니온 파인드 문풀 
 * @author MYLG
 *
 */
public class Main {
	static int[] parent;
	static int[] friends;//각 i 별 친구 관계 수 저장용 
	//find
	static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	//union
	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a != b) {
			parent[b] = a;
			friends[a] += friends[b];
			friends[b] = 1;
		}
		return friends[a];
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int TC = kb.nextInt();
		
		for(int t =0; t<TC; t++) {
			Map<String, Integer> map = new HashMap<>();
			int idx = 0;
			int F = kb.nextInt();
			parent = new int[F*2]; //최대
			friends = new int[F*2];
			for(int i=1; i<F*2; i++) parent[i]= i;
			
			Arrays.fill(friends, 1);//자기 자신에 대한 관계 1명 초기화
			
			for(int i = 0; i<F; i++) {
				String a = kb.next();
				String b = kb.next();
				
				if(!map.containsKey(a)) map.put(a, idx++);
				if(!map.containsKey(b)) map.put(b, idx++);
				
				System.out.println(union(map.get(a), map.get(b)));
			}
		}
	}
}