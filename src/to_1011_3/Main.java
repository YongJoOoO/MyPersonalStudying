package to_1011_3;

import java.util.*;
import java.util.Scanner;

/*4195번. 친구 네트워크 - 유니온 파인드 - RE */
public class Main {
	static int TC;
	static int F;
	static int[] parent;
	static int[] level;
	//find
	static int find(int a) {
		if(a == parent[a]) {
			return a;
		}else return parent[a] = find(parent[a]);
	}
	
	//union
	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a!=b) {
			parent[b]= a;
			level[a] += level[b];//b의 친구를 a에 누적시킴
			level[b] = 1;
		}
		return level[a]; //a에 저장된 친구 관계의 수 
	}
	
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		TC = kb.nextInt();//테케 수
		for(int t=0; t<TC; t++) {
			
			F = kb.nextInt();//친구 관계의 수 
			parent = new int[F*2];
			level = new int[F*2];
			Arrays.fill(level, 1);
			
			for(int i=0; i<F*2; i++) parent[i] = i;
			//이름,, 인덱스 번호 
			HashMap<String, Integer> map = new HashMap<>();
			
			int idx = 0;
			//친구 관계별로 입력받기 
			for(int i=0; i<F; i++) {
				String a = kb.next();
				String b = kb.next();
				if(!map.containsKey(a)) {
					//기존 map에 친구 이름 없는 경우 인덱스를 부여한다.
					map.put(a, idx++);
				}
				if(!map.containsKey(b)) {
					map.put(b, idx++);
				}			
				System.out.println(union(map.get(a), map.get(b)));
			}
		}	
	}
}