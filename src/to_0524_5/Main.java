package to_0524_5;

import java.util.*;

/*1427번. 소트인사이드  */
public class Main {
	//solution
	public String solution(String n ) {
		String answer = "";
		Integer[] tmp = new Integer[n.length()];
		int i = 0;
		for(char x : n.toCharArray()) {
			tmp[i] = Character.getNumericValue(x);
			i++;
		}
		
		Arrays.sort(tmp, Collections.reverseOrder());
		
		for(int j = 0; j<tmp.length; j++) {
			answer += tmp[j];
		}

		return answer; 
	}	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String x  = kb.next();
		System.out.println(T.solution(x));
	}
}