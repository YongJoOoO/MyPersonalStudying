package A_SSAFY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution{
	
	//솔루션 함수 
	public int solution(int n, int[] arr) {
		int answer= 0;
	
		HashMap<Integer, Integer> map = new HashMap<>();
		//중복없애서 map에 담기 
		for(int i=0; i<n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
	
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int key : map.keySet()) {
			list.get(key);
		}
		
		for(int i=0; i<list.size(); i++) {
			
			for(int j=i+1; j<list.size(); j++) {
				if(list.get(i) + list.get(j) == 0) {
					answer++;
				}
			}
		}
		
		return answer;
	}
	
	//실행 메인 
	public static void main(String args[]) throws Exception {
		Solution S = new Solution();
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		
		int[] answer = new int[T+1]; //각 answer를 여기 담고 
		
		//입력 
		for(int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			for(int i=0; i<n; i++) {
				arr[i] = sc.nextInt();
			}
			
			answer[t] = S.solution(n, arr);
		}
		
		//각 케이스별 답 출력
		for(int i=1; i<=T; i++) {
			System.out.println("#"+i+ " " + answer[i]);
		}

		sc.close(); // 사용이 끝난 스캐너 객체를 닫습니다.
	}
}