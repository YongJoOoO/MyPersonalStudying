package to_0306;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* 04-03. 매출액의 종류
N일간의 매출기록과 연속구간의 길이 K가 주어지면 
첫 번째 구간부터 각 구간별 매출액의 '종류'를 출력하는 프로그램을 작성하세요.
*/
public class Main4 {
	//솔루션 함수
	public ArrayList<Integer> solution(int n, int k, int[] arr){
		ArrayList<Integer> answer = new ArrayList<>();
		
		HashMap<Integer, Integer> HM = new HashMap<>();
		//중복 값 없도록 해쉬맵 최초 세팅 
		for(int i = 0 ; i<k-1; i++) {
			HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
		}
		//Two pointers 알고리즘 사용 
		int lt = 0;
		for(int rt = k-1; rt <n; rt++) {
			HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
			answer.add(HM.size());
			HM.put(arr[lt], HM.get(arr[lt])-1);
			if(HM.get(arr[lt]) == 0)  HM.remove(arr[lt]);
			lt++;
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main4 T = new Main4();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		
		int[] arr = new int[n];
		for(int i = 0; i<n ; i++) {
			arr[i] = kb.nextInt();
		}		
		for(int x : T.solution(n, k, arr)) System.out.print(x + " ");
	}
}