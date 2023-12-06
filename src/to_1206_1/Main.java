package to_1206_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 해시를 사용한 집합과 맵 - 문풀 
 * 
 * 숫자 카드 
 */
public class Main {
	
	static Map<Integer, Integer> map;
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		map = new HashMap<>();
		
		int N = kb.nextInt();
		for(int i=0; i<N; i++) {
			int num = kb.nextInt();
			map.put(num, 1);
		}
		
		//이제 체크
		int M = kb.nextInt();
		List<Integer> list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			int val = kb.nextInt();
			if(map.containsKey(val)) {
				list.add(1);//갖고 있으니까
			}else {
				//안갖고 있으면 
				list.add(0);
			}
		}
		
		//답 출력 
		for(int x : list) System.out.print(x + " ");
	}

}
