package to_1206_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 해시맵
 * @author MYLG
 *
 */
public class Main {
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb= new Scanner(System.in);
		int N = kb.nextInt();
		int M = kb.nextInt();
		
		Map<String, Integer> map1 = new HashMap<>(); //key : 이름 - 넘버 
		Map<Integer, String> map2 = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String key = kb.next();
			
			map1.put(key, i);
			map2.put(i, key);
		}
		
		List<String> list = new ArrayList<>();
		
		for(int i=0; i<M; i++) {
			//M개의 질문에 답하기 
			String question = kb.next();
			//만약에 숫자값이면 
			if(question.chars().allMatch(Character::isDigit)) {
				int num = Integer.parseInt(question);
				list.add(map2.get(num));
			}else {
				//문자열이면
				String ans = String.valueOf(map1.get(question));
				list.add(ans);
			}
		}		
		//출력
		for(String x : list) {
			System.out.println(x);
		}
	}
}