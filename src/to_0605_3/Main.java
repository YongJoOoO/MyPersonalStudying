package to_0605_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/*17298번. 오큰수 구하기 */
public class Main {
	//정적변수로 입출력 변수 세팅 
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));	
	
	//실행 메인 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];//하나씩 받는 용도 
		
		int[] setO = new int[n];//오큰수 저장용
		String[] str = bf.readLine().split(" ");
		for(int i =0; i<n; i++) arr[i] =Integer.parseInt(str[i]);
		
		Stack<Integer> st = new Stack<>();
		
		//초기화 일단 최초값 세팅
		st.push(0);//0번 값과 수열값 비교할거야 
		
		for(int i =0; i<n; i++) {
			//스택 비지않고, 현재 수열값이 > top값보다 큰 동안 pop
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				setO[st.pop()] = arr[i];//현재값을 pop한 인덱스값 정답배열에 세팅 
			}
			st.push(i); //신규 데이터 push 
		}
		
		//반복문 탈출 이후에도 여전히 스택에 특정값이 존재 == 오큰수 없는 인덱스 존재하는 거임 -1 세팅 
		while(!st.isEmpty()) {
			//반복문 모두 돌고나왔는데, 스택 빈 상태가 아닌 경우 -1 세팅 없다는 거니까 
			setO[st.pop()] = -1;
		}
		
		//정답 출력
		for(int x : setO) {
			bw.write(x+" ");
		}
		
		bw.write("\n");
		bw.flush();
	}
}