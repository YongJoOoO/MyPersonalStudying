package to_0307;

import java.util.HashMap;
import java.util.Scanner;

/* 04-04. 모든 아나그램 찾기 (해쉬, 투포인터, 슬라이딩 윈도우)
[설명]
S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램을 작성하세요.
아나그램 판별시 대소문자가 구분됩니다. 부분문자열은 연속된 문자열이어야 합니다.
*/
public class Main2 {
	//솔루션 함수
	public int solution(String a, String b) {
		int answer =0;
		HashMap<Character, Integer> aM = new HashMap<>();
		HashMap<Character, Integer> bM = new HashMap<>();
		//우선 b가 기준T 가 되므로 미리 세팅해둠
		for(char x : b.toCharArray()) {
			bM.put(x, bM.getOrDefault(bM, 0)+1);
		}
		
		int L = b.length()-1;
		for(int i = 0; i<L; i++) {
			aM.put(a.charAt(i), aM.getOrDefault(a.charAt(i), 0)+1);
		}
		
		//투포인터
		int lt = 0;
		for(int rt = L; rt<a.length(); rt++) {
			aM.put(a.charAt(rt), aM.getOrDefault(a.charAt(rt), 0)+1);
			//비교
			if(aM.equals(bM))answer++;
			aM.put(a.charAt(lt), aM.get(a.charAt(lt))-1);
			if(aM.get(a.charAt(lt)) == 0) aM.remove(a.charAt(lt));
			lt++;
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main2 T = new Main2();
		Scanner kb = new Scanner(System.in);
		
		String a = kb.next();
		String b= kb.next();
		
		System.out.println(T.solution(a, b));
	}
}