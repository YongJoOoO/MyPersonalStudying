package to_0605_9;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/*11931번. 수 정렬 4 	*/
public class Main {
	//정적변수로 입출력 변수 세팅 
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(bf.readLine());
		
		ArrayList<Integer> arr= new ArrayList<>();
		String[] s = new String[n];
		for(int i=0; i<n; i++) {
			s[i] = bf.readLine();
			arr.add(Integer.parseInt(s[i]));
		}
		
		Collections.sort(arr, Collections.reverseOrder());
		
		for(int x : arr) {
			bw.write(x+"\n");
		}
		bw.flush();
	}
}