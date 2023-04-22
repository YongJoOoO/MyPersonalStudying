package to_0420;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
// Scanner 사용시 시간초과 => BufferedReader 사용 방법 
public class Main {
	
	//** BufferReader 사용 시 throws IOException 추가 
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Main T = new Main();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//** int 형으로 입력 받으려면 String으로 받아서 형변환
		int N = Integer.parseInt(bf.readLine());
		int[] arr1 = new int[N];
		//** 공백 단위로 받을 때는 split(" ")으로 끊어서 받기 
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
		int[] tmp = new int[M];
		
		//** 출력할 때, BufferedWriter로 받고 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//** bw.write()는 버퍼에 있는 값 전부 출력 
		for(int i=0; i<M; i++) {
			bw.write(tmp[i]+ " ");
		}
		// 버퍼에 남아있는 데이터 모두 출력 
		bw.flush();
		// 스트림 닫기
		bw.close();
	}

}
