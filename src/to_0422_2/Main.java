package to_0422_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
/*1269번. 대칭 차집합 
 * */
public class Main {
	//입출력 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//정적변수 선언
	static int aN;
	static int bN; 
	//솔루션 함수 
	public int solution(int[] a, int[] b) {
		int answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<aN; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0)+1);
		}
		for(int i=0; i<bN; i++) {
			map.put(b[i], map.getOrDefault(b[i], 0)+1);
		}
		//==1 인 거 카운팅해서 answer 리턴
		// ** map 의 키 전체 순회 map.keySet() 
		for (Integer key : map.keySet()) {
			if (map.get(key) == 1) {
				answer++;
			}
		}
		return answer;
	}
	
	//실행 메인 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Main T = new Main();
		
		String[] arr = br.readLine().split(" ");
		
		aN = Integer.parseInt(arr[0]);
		bN = Integer.parseInt(arr[1]);
		
		int[] a = new int[aN];
		int[] b = new int[bN];
		
		String[] tmp1 = br.readLine().split(" ");
		for(int i=0; i<aN; i++) {
			a[i] = Integer.parseInt(tmp1[i]);
		}
			
		String[] tmp2 = br.readLine().split(" ");
		for(int i=0; i<bN; i++) {
			b[i] = Integer.parseInt(tmp2[i]);
		}
		
		System.out.println(T.solution(a, b));

	}
}