package to_0422;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

/*10816번. 숫자 카드 2 */
public class Main {
	//솔루션
	public int[] solution(int n, int[] arr1, int m, int[] arr2) {
		int[] answer = new int[m];
		HashMap<Integer, Integer> map = new HashMap<>();
		//1) 중복없이 담고
		for(int x : arr1) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
		//2) m짜리 돌면서 겹치는 값 있을 때. answer 에 담는데
		for(int i=0; i<m; i++) {
			if(map.containsKey(arr2[i])==true) {//있으면 빈도수 
				answer[i] = map.getOrDefault(arr2[i], 0);
			}else { //없으면 0
				answer[i] = 0;
			}
		}
		return answer;
	}
	
	//실행 메인  
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Main T = new Main();
		//Scanner kb = new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr1 = new int[N];
		String[] s = bf.readLine().split(" ");
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = Integer.parseInt(s[i]);
		}
		
		int M = Integer.parseInt(bf.readLine());
		int[] arr2 = new int[M];
		String[] t= bf.readLine().split(" ");
		for(int i=0; i<arr2.length; i++) {
			arr2[i]= Integer.parseInt(t[i]);
		}
		//호출 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int x : T.solution(N, arr1, M, arr2)) {
			bw.write(x + " ");
		}
		/*
		for(int i=0; i<M; i++) {
			bw.write(tmp[i]+ " ");
		}
		*/
		bw.flush();
		bw.close();
	}
}