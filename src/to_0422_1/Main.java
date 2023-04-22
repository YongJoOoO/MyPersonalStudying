package to_0422_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/* 1302번. 베스트셀러
 * */
public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//솔루션 함수 
	public String solution(int n, String[] arr) {
		String answer = "";
		
		//문자열 알파벳 순으로 정렬
		Arrays.sort(arr);
		HashMap<String, Integer> map = new HashMap<>();
		//1) 담고
		for(String x: arr) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//2) 빈도수최대를 max에 담기 
		int max = Integer.MIN_VALUE;
		for(String x : arr) {
			if(max < map.getOrDefault(x, 0)) {
				max = map.getOrDefault(x, 0);
			}
		}
		//3) max 출력하되, 동일한 max 책 찾으면 그 중 알파벳 순 하나 출력
		for(String x : arr) {
			if(map.getOrDefault(x, 0)== max){
				answer =x;
				break;
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) throws IOException  {
		// TODO Auto-generated method stub
		Main T= new Main();
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for(int i=0; i<N; i++) { 
			arr[i] = br.readLine();
		}
		
		System.out.println(T.solution(N, arr));
	}
}