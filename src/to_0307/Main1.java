package to_0307;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/* 04-03. 매출액의 종류 Re
[입력]
첫 줄에 N(5<=N<=100,000)과 K(2<=K<=N)가 주어집니다.
두 번째 줄에 N개의 숫자열이 주어집니다. 각 숫자는 500이하의 음이 아닌 정수입니다.
[출력]
첫 줄에 각 구간의 매출액 종류를 순서대로 출력합니다.*/
public class Main1 {
	//솔루션 함수 
	public ArrayList<Integer> solution(int n, int k, int[]arr){
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> map= new HashMap<>();
		//초기값. 0부터 k-1까지 간격일수 동안의 매출액 종류 put처리
		for(int i =0; i<k-1; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		//Two Pointers 알고리즘
		int lt = 0;
		for(int rt = k-1; rt<n; rt++) {
			//rt가 찍은 애를 담기 
			map.put(arr[rt], map.getOrDefault(arr[rt], 0)+1);
			//종류별로 카운팅 했으니까 answer에도 담기
			answer.add(map.size());
			
			//rt한칸 증가하면 기존에 lt찍었던 애는 가져와서 -1 감소해줘야 함 
			map.put(arr[lt], map.get(arr[lt])-1);
			//lt 감소했더니 0이 됐으면 그 종류는 카운팅 하면 안되니까 remove처리
			if(map.get(arr[lt]) == 0) map.remove(arr[lt]); 
			lt++;//lt도 한칸 증가
		}
		return answer;
	}
	//실행 메인 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main1 T = new Main1();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int k = kb.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = kb.nextInt();
		}
		//출력 
		for(int x : T.solution(n, k, arr)) {
			System.out.print(x + " ");
		}
	}
}