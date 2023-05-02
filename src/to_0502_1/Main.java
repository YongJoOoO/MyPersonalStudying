package to_0502_1;


import java.io.*;
import java.util.*;

public class Main {
	//입출력 변수 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	//실행 메인 
	public static void main(String[] args) throws IOException{
		
		int t = Integer.parseInt(br.readLine());
		
		while(t--> 0) {
			Stack<Character> st = new Stack<>();
			//끝을 알리는 \n개행 문자 담고 
			String str = br.readLine() + "\n";
			for(char x : str.toCharArray()) {
				if(x == ' ' || x =='\n') {
					while(!st.isEmpty()) {
						bw.write(st.pop());
					}
					bw.write(x);;
				}else st.push(x);
			}
		}
		
		bw.flush();
	}
}